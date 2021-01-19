package org.ylc.frame.cloud.authserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.ylc.frame.cloud.authserver.dto.OauthClientDetail;

import java.util.List;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 当使用数据库存储客户端信息时的维护接口
 * 客户端信息：Client-ID，client-secret等信息
 *
 * @author YuLc
 * @since 1.0.0
 */
@Slf4j
@ConditionalOnProperty(prefix = "oauth-store", name = "client", havingValue = "db")
@RequestMapping("/auth/client")
@RestController
public class ClientJdbcController {

    @Autowired
    private JdbcClientDetailsService jdbcClientDetailsService;

    @GetMapping("/list")
    public List<ClientDetails> clientList() {
        List<ClientDetails> clients = jdbcClientDetailsService.listClientDetails();
        clients.forEach(
                client -> log.info(client.getClientId())
        );
        return clients;
    }

    /**
     * 新增客户端
     *
     * @param oauthClient 客户端数据
     */
    @PostMapping("/add")
    public String addClient(@RequestBody OauthClientDetail oauthClient) {
        BaseClientDetails clientDetails = new BaseClientDetails();
        BeanUtils.copyProperties(oauthClient, clientDetails);

        jdbcClientDetailsService.addClientDetails(clientDetails);
        return "success";
    }

    /**
     * 更新客户端信息
     *
     * @param oauthClient 客户端数据
     */
    @PostMapping("/update")
    public String updateClient(@RequestBody OauthClientDetail oauthClient) {
        if (StringUtils.isEmpty(oauthClient.getClientId())) {
            throw new NoSuchClientException("客户端ID不能为空");
        }
        BaseClientDetails clientDetails = new BaseClientDetails();
        BeanUtils.copyProperties(oauthClient, clientDetails);

        jdbcClientDetailsService.updateClientDetails(clientDetails);
        return "success";
    }

    /**
     * 更新客户端秘钥
     *
     * @param clientId 客户端ID
     * @param secret   秘钥
     */
    @GetMapping("/updateSecret")
    public String updateClientSecret(String clientId, String secret) {
        jdbcClientDetailsService.updateClientSecret(clientId, secret);
        return "success";
    }

    /**
     * 移除客户端
     *
     * @param clientId 客户端ID
     */
    @GetMapping("/remove/{clientId}")
    public String removeClient(@PathVariable String clientId) {
        jdbcClientDetailsService.removeClientDetails(clientId);
        return "success";
    }

}
