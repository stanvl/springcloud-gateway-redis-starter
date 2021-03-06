package com.guzhandong.springformwork.gateway.route.config;


import com.guzhandong.springformwork.gateway.route.RouteAlterHandler;
import com.guzhandong.springformwork.gateway.route.redis.RedisRouteDefinitionRepository;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ConditionalOnClass(StringRedisTemplate.class)
@ConditionalOnBean(StringRedisTemplate.class)
@AutoConfigureBefore(GatewayAutoConfiguration.class)
public class AutoConfigRedisRouteRepository {


    @Bean
    public RouteAlterHandler routeAlterHandler(){
        return new RouteAlterHandler();
    }

    @Bean
    public RouteDefinitionRepository redisRouteDefinitionRepository(){
        return new RedisRouteDefinitionRepository();
    }
}
