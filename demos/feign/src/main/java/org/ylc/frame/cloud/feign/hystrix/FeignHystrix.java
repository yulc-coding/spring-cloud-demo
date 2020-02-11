package org.ylc.frame.cloud.feign.hystrix;

import org.springframework.stereotype.Component;
import org.ylc.frame.cloud.feign.client.EurekaClientFeign;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 熔断机制
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-11
 */
@Component
public class FeignHystrix implements EurekaClientFeign {

    @Override
    public String feignTest(String msg) {
        return String.format("return Error ! get msg : %s", msg);
    }
}
