//package project.myblog.infrastructure.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.graphql.execution.GraphQlSource;
//import org.springframework.graphql.server.WebGraphQlHandler;
//import org.springframework.graphql.server.webmvc.GraphQlWebSocketHandler;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//import java.time.Duration;
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    private final WebGraphQlHandler webGraphQlHandler;
//    private final ContextHandshakeInterceptor contextHandshakeInterceptor;
//
//    public WebSocketConfig(WebGraphQlHandler webGraphQlHandler,
//                           ContextHandshakeInterceptor contextHandshakeInterceptor) {
//        this.webGraphQlHandler = webGraphQlHandler;
//        this.contextHandshakeInterceptor = contextHandshakeInterceptor;
//    }
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(graphQlWebSocketHandler(), "/ws/graphql")
//                .setAllowedOrigins("*")
//                .addInterceptors(contextHandshakeInterceptor);
//    }
//
//    @Bean
//    public GraphQlWebSocketHandler graphQlWebSocketHandler() {
//        return new GraphQlWebSocketHandler(webGraphQlHandler,
//                                           new MappingJackson2HttpMessageConverter(),
//                                           Duration.ofSeconds(60));
//    }
//}