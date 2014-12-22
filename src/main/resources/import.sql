INSERT INTO users (username,password,enabled,role_id) VALUES ('eugenio','1234',true,1);
INSERT INTO users (username,password,enabled,role_id) VALUES ('rodrigo','1234',true,1);
INSERT INTO users (username,password,enabled,role_id) VALUES ('admin','1234',true,2);
INSERT INTO user_roles (role_id,authority) VALUES (1,'ROLE_USER');
INSERT INTO user_roles (role_id,authority) VALUES (2,'ROLE_ADMIN');