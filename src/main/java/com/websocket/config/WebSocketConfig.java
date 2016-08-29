package com.websocket.config;

import com.websocket.handler.MyWebSocketHander;
import com.websocket.interceptor.MyHandshakeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc
@EnableWebSocket//开启websocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements
        WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyWebSocketHander(),"/echo")
                .addInterceptors(new MyHandshakeInterceptor()).setAllowedOrigins("*"); //支持websocket 的访问链接
        //sockjs如果不支持就会转化为ajax轮训方式
        registry.addHandler(new MyWebSocketHander(),"/sockjs/echo")
                .addInterceptors(new MyHandshakeInterceptor()).setAllowedOrigins("*")
                .withSockJS(); //不支持websocket的访问链接
    }

}