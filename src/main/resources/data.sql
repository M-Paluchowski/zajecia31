INSERT INTO USER(username, password, enabled) VALUES ('admin', '{noop}admin', true );
INSERT INTO USER(username, password, enabled) VALUES ('user', '{noop}user', true );

INSERT INTO USER_ROLE(username, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) VALUES ('user', 'ROLE_USER');