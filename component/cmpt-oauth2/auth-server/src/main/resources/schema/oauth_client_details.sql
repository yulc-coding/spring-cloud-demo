
CREATE TABLE oauth_client_details (
	client_id VARCHAR ( 32 ) PRIMARY KEY COMMENT '客户端ID',
	resource_ids VARCHAR ( 256 ),
	client_secret VARCHAR ( 256 ) NOT NULL COMMENT '客户端秘钥，此处不能是明文，需要加密',
	scope VARCHAR ( 256 ) NOT NULL COMMENT '客户端授权范围',
	authorized_grant_types VARCHAR ( 256 ) COMMENT '客户端授权类型',
	web_server_redirect_uri VARCHAR ( 256 ) COMMENT '服务端回调地址',
	authorities VARCHAR ( 256 ),
	access_token_validity INTEGER,
	refresh_token_validity INTEGER,
	additional_information VARCHAR ( 4096 ),
	autoapprove VARCHAR ( 256 )
) COMMENT '客户端配置信息';


create table oauth_client_token (
  authentication_id VARCHAR(256) PRIMARY KEY,
  token_id VARCHAR(256),
  token BLOB,
  client_id VARCHAR(256),
  user_name VARCHAR(256)
);


create table oauth_access_token (
  authentication_id VARCHAR(256) PRIMARY KEY,
  token_id VARCHAR(256),
  token BLOB,
  client_id VARCHAR(256),
  user_name VARCHAR(256),
  authentication BLOB,
  refresh_token VARCHAR(256)
) COMMENT '访问令牌';


create table oauth_refresh_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication BLOB
);


create table oauth_code (
  code VARCHAR(256),
  authentication BLOB
) COMMENT '授权码信息';


create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);


-- customized oauth_client_details table
create table ClientDetails (
  appId VARCHAR(256) PRIMARY KEY,
  resourceIds VARCHAR(256),
  appSecret VARCHAR(256),
  scope VARCHAR(256),
  grantTypes VARCHAR(256),
  redirectUrl VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(256)
);