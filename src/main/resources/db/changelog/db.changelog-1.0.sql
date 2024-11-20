--liquibase formatted sql
--changeset pep_sxx:1
CREATE SEQUENCE IF NOT EXISTS user_seq
    START WITH 50 INCREMENT BY 50;

--changeset pep_sxx:3
CREATE TABLE IF NOT EXISTS user_role
(
    id   BIGINT      NOT NULL UNIQUE PRIMARY KEY,
    name VARCHAR(16) NOT NULL UNIQUE
);

--changeset pep_sxx:4
CREATE TABLE IF NOT EXISTS "user"
(
    id      BIGINT DEFAULT nextval('user_seq') PRIMARY KEY,
    name    VARCHAR(64) NOT NULL,
    email   VARCHAR(64) NOT NULL UNIQUE,
    pass    VARCHAR(64) NOT NULL,
    role_id INTEGER REFERENCES user_role (id)
);