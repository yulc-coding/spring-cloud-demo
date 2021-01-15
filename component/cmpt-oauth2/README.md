## OAuth2

+--------+                                    +---------------+
|        | ---(A)-- Authorization Request --> |   Resource    |
|        | <--(B)-- Authorization Grant ----- |     Owner     |
|        |                                    +---------------+
|        |
|        |                                    +---------------+
| Client | ---(C)-- Authorization Grant ----> | Authorization |
|        | <--(D)------ Access Token -------- |     Server    |
|        |                                    +---------------+
|        |
|        |                                    +---------------+
|        | ---(E)------ Access Token -------> |   Resource    |
|        | <--(F)--- Protected Resource ----- |    Server     |
+--------+                                    +---------------+

### auth-server
认证中心，验证账号、密码，生成Token，存储Token，检查Token，刷新Token，权限校验等都是在这里处理；

#### 获取token
```
POST http://localhost:9000/oauth/token?grant_type=password&username=admin&password=123456&scope=all
Accept: */*
Cache-Control: no-cache
Authorization: Basic dXNlci1jbGllbnQ6dXNlci1zZWNyZXQtODg4OA==
```
* username和password为账号密码
* scope=all：权限相关，认证服务器中配置
* 在请求头中加入Authorization: base64(clientId:clientSecret)