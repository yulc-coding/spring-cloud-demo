package org.ylc.frame.cloud.dubbo.api;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.ylc.frame.cloud.ProviderApiService;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-11-13
 */
@Service(version = "0.0.1")
public class ProviderApiServiceImpl implements ProviderApiService {

    @Value("${spring.application.name}")
    private String serverName;

    @Value("${server.port}")
    private Integer port;

    @Override
    public String getProvider() {
        return String.format("from %s, port %d", serverName, port);
    }
}
