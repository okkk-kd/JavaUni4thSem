DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL
);
--DROP TABLE IF EXISTS dogs;
--CREATE TABLE dogs (
--    id BIGSERIAL PRIMARY KEY,
--    name varchar(100),
--    breed varchar(100),
--    user_id BIGSERIAL
--);