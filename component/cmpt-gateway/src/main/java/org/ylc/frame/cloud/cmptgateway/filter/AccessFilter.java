package org.ylc.frame.cloud.cmptgateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 接口权限校验
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-11-06
 */
@Configuration
public class AccessFilter implements GlobalFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String method = request.getMethodValue();
        String url = request.getPath().value();
        LOGGER.debug("url:{},method:{},headers:{}", url, method, request.getHeaders());

        /*
         * 1、校验token是否有效
         * 2、不需要网关鉴权的不处理
         * 3、需要校验的调用鉴权服务，并进入下一个 filter
         */
        chain.filter(exchange);
        return null;
    }

    public boolean verifyToken(String token) {

        return true;
    }

    /**
     * 网关拒绝，返回401
     */
    private Mono<Void> unauthorized(ServerWebExchange serverWebExchange) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        DataBuffer buffer = serverWebExchange.getResponse()
                .bufferFactory().wrap(HttpStatus.UNAUTHORIZED.getReasonPhrase().getBytes());
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
    }
}
