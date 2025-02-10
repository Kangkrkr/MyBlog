//package project.myblog.infrastructure.config;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.PreDestroy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.embedded.RedisServer;
//
//import java.io.IOException;
//import java.util.Optional;
//
//@Configuration
//public class EmbeddedRedisConfig {
//
//    private final RedisServer redisServer;
//
//    public EmbeddedRedisConfig() {
//        // 기본적으로 6379 포트를 사용. 필요하면 다른 포트로 변경 가능
//        this.redisServer = new RedisServer(6379);
//    }
//
//    // Redis 서버 시작
//    @PostConstruct
//    public void startRedis() throws IOException {
//        redisServer.start();
//    }
//
//    // 애플리케이션 종료 시 Redis 서버 중단
//    @PreDestroy
//    public void stopRedis() {
//        Optional.ofNullable(redisServer).ifPresent(RedisServer::stop);
//    }
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory("localhost", 6379);
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        // Key와 Value를 String으로 직렬화
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        return redisTemplate;
//    }
//}