## OAuth2

### auth-server
认证中心，负责Token的生成、认证，权限校验

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