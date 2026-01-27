BEGIN TRANSACTION;

INSERT INTO users(hash, user_name) VALUES ('test','FirstUser!');

commit transaction;