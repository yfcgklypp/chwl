package com.chwl.cn.ribbon.config;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

@Configuration
public class CustomRoundRobinRule extends AbstractLoadBalancerRule{

	private AtomicInteger nextServerCyclicCounter;
	private static final boolean AVAILABLE_ONLY_SERVERS = true;
	private static final boolean ALL_SERVERS = false;

	// 总共被调用的次数，目前要求每台被调用5次
	private int total = 0;
	// 当前提供服务的机器号
	private int currentIndex = 0;

	private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);

	public CustomRoundRobinRule() {
		nextServerCyclicCounter = new AtomicInteger(0);
	}

	public CustomRoundRobinRule(ILoadBalancer lb) {
		this();
		setLoadBalancer(lb);
	}

	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			log.warn("no load balancer");
			return null;
		}

		Server server = null;
		int count = 0;
		while (server == null && count++ < 10) {
			List<Server> upList = lb.getReachableServers();
			List<Server> allServers = lb.getAllServers();
			int upCount = upList.size();
			int serverCount = allServers.size();

			if ((upCount == 0) || (serverCount == 0)) {
				log.warn("No up servers available from load balancer: " + lb);
				return null;
			}
//			if (total < 5) {
			if (total < 2) {
				server = upList.get(currentIndex);
				total++;
			} else {
				total = 0;
				currentIndex++;
				if (currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}

			if (server == null) {
				/* Transient. */
				Thread.yield();
				continue;
			}

			if (server.isAlive() && (server.isReadyToServe())) {
				return (server);
			}

			// Next.
			server = null;
		}

		if (count >= 10) {
			log.warn("No available alive servers after 10 tries from load balancer: " + lb);
		}
		return server;
	}

	/**
	 * Inspired by the implementation of {@link AtomicInteger#incrementAndGet()}
	 * .
	 *
	 * @param modulo
	 *            The modulo to bound the value of the counter.
	 * @return The next value.
	 */
	private int incrementAndGetModulo(int modulo) {
		for (;;) {
			int current = nextServerCyclicCounter.get();
			int next = (current + 1) % modulo;
			if (nextServerCyclicCounter.compareAndSet(current, next))
				return next;
		}
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {

	}
}
