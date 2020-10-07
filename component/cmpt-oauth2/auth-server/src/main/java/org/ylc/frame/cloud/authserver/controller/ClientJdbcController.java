package org.ylc.frame.cloud.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 当使用数据库存储客户端信息时的维护接口
 * 客户端信息：Client-ID，client-secret等信息
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-10-03
 */
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
                client -> System.out.println(client.getClientId())
        );
        return clients;
    }

    @PostMapping("/add")
    public String addClient(@RequestBody BaseClientDetails clientDetails) {
        jdbcClientDetailsService.addClientDetails(clientDetails);
        return "success";
    }

    @PostMapping("/update")
    public String updateClient(@RequestBody BaseClientDetails clientDetails) {
        jdbcClientDetailsService.updateClientDetails(clientDetails);
        return "success";
    }

    @GetMapping("/updateSecret")
    public String updateClientSecret(String clientId, String secret) {
        jdbcClientDetailsService.updateClientSecret(clientId, secret);
        return "success";
    }

    @GetMapping("/remove")
    public String removeClient(String clientId) {
        jdbcClientDetailsService.removeClientDetails(clientId);
        return "success";
    }

}
