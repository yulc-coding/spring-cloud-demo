package org.ylc.frame.cloud.cmptsentinel.server;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;
import org.ylc.frame.cloud.cmptsentinel.handler.BlockHandler;

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

    /**
     * blockHandler 为指定函数，必须为public、static ,且返回类型和原方法一致，
     * blockHandlerClass 为对应类
     */
    @SentinelResource(value = "blockTest", blockHandler = "quickReturn", blockHandlerClass = BlockHandler.class)
    public String blockHandlerTest() {
        return "Block Test";
    }

    @SentinelResource(value = "fallbackTest", fallback = "")
    public String fallbackTest() {
        return "Fallback Test";
    }

}
