CREATE TABLE oauth_client_details (
	client_id VARCHAR ( 32 ) PRIMARY KEY,
	resource_ids VARCHAR ( 256 ),
	client_secret VARCHAR ( 256 ) NOT NULL,
	scope VARCHAR ( 256 ),
	authorized_grant_types VARCHAR ( 256 ),
	web_server_redirect_uri VARCHAR ( 256 ),
	authorities VARCHAR ( 256 ),
	access_token_validity INTEGER,
	refresh_token_validity INTEGER,
	additional_information VARCHAR ( 4096 ),
	autoapprove VARCHAR ( 256 )
) COMMENT '客户端信息';