package org.ylc.frame.cloud.zuul.config;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 熔断器
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-13
 */
@Component
public class ZuulFallbackProvider implements FallbackProvider {

    /**
     * 要配置熔断的服务名
     * '*' 表示所有服务都配置
     */
    @Override
    public String getRoute() {
        return "*";
    }


    @Override
    @SuppressWarnings("NullableProblems")
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {

            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() {
                return this.getStatusCode().getReasonPhrase();
            }

            /**
             * 设置响应头
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            /**
             * 设置相应内容
             */
            @Override
            public InputStream getBody() {
                return new ByteArrayInputStream("服务异常，请稍后再试！".getBytes());
            }

            @Override
            public void close() {

            }
        };
    }
}
