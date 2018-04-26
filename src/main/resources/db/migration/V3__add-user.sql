CREATE TABLE users (username VARCHAR(100) NOT NULL PRIMARY KEY, user_email VARCHAR(30), encoded_password VARCHAR(255));
INSERT INTO users (username, user_email, encoded_password) VALUES ('user1', 'aaa@aaa', 'ce5f8d0c5790bf82e9b253d362feb51ba02853301ae24149b260bd30acb00f1b2a0d8b18bbff97a9' /*demo*/);
INSERT INTO users (username, user_email, encoded_password) VALUES ('user2', 'bbb@bbb', 'ce5f8d0c5790bf82e9b253d362feb51ba02853301ae24149b260bd30acb00f1b2a0d8b18bbff97a9' /*demo*/);
ALTER TABLE loto_historys ADD username VARCHAR(100) NOT NULL DEFAULT 'user1';
ALTER TABLE loto_historys ADD CONSTRAINT FK_LOTO_HISTORYS_USERNAME FOREIGN KEY (username) REFERENCES users;