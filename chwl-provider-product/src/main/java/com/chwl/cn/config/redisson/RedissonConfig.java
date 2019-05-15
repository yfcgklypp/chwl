package com.chwl.cn.config.redisson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.config.SentinelServersConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

	@Value("${spring.redis.sentinel.master}")
	private String master;
	
	@Value("${spring.redis.sentinel.nodes}")
	private String redisNodes;
	
	@Value("${spring.redis.password}")
	private String password;
	
	@Value("${spring.redis.timeout}")
	private Integer timeout;
	
	/**  
     * 哨兵模式 redisson 客户端
     * @return
     */

    @Bean
    RedissonClient redissonSentinel() {
        Config config = new Config();
        String[] nodes = redisNodes.split(",");
        List<String> newNodes = new ArrayList(nodes.length);
        Arrays.stream(nodes).forEach((index) -> newNodes.add(index.startsWith("redis://") ? index : "redis://" + index));

        SentinelServersConfig serverConfig = config.useSentinelServers()
                .addSentinelAddress(newNodes.toArray(new String[0]))
                .setMasterName(master)
                .setReadMode(ReadMode.SLAVE)
                .setTimeout(timeout);
//                .setMasterConnectionPoolSize(redisPoolSize)
//                .setSlaveConnectionPoolSize(redisPoolSize);

        if (StringUtils.isNotBlank(password)) {
            serverConfig.setPassword(password);
        }

        return Redisson.create(config);
    }
}
