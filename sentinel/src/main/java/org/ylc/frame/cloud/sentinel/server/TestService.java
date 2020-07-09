package org.ylc.frame.cloud.sentinel.server;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-07-08
 */
@Service
public class TestService {

    @SentinelResource(value = "sentinelTest")
    public String sentinelTest() {
        return "Sentinel Test";
    }
}
