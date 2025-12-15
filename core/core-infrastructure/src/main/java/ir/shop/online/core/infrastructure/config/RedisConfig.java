package ir.shop.online.core.infrastructure.config;

import ir.shop.online.core.domain.model.otp.OTP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, ir.shop.online.core.domain.model.otp.OTP> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, OTP> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Serializer برای کلیدها
        template.setKeySerializer(new StringRedisSerializer());

        // Serializer برای مقادیر (JSON)
        RedisSerializer<OTP> serializer =
                new JacksonJsonRedisSerializer<>(OTP.class);

        template.setValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }
}
