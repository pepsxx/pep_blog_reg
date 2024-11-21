--liquibase formatted sql

--changeset pep_sxx:1
CREATE SEQUENCE IF NOT EXISTS user_seq
    START WITH 100 INCREMENT BY 50;

--changeset pep_sxx:2
CREATE TABLE IF NOT EXISTS "user"
(
    id                    BIGINT DEFAULT nextval('user_seq') PRIMARY KEY,
    name                  VARCHAR(64) NOT NULL,
    email                 VARCHAR(64) NOT NULL UNIQUE,
    pass                  VARCHAR(64) NOT NULL,
    data_time_registering TIMESTAMP   NOT NULL
);

--changeset pep_sxx:3
CREATE TABLE IF NOT EXISTS role
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(16) NOT NULL UNIQUE CHECK ( name IN ('ROLE_ADMIN', 'ROLE_USER'))
);

--changeset pep_sxx:4
CREATE TABLE IF NOT EXISTS roles_users
(
    user_id BIGINT REFERENCES "user" (id),
    role_id BIGINT REFERENCES role (id),
    PRIMARY KEY (role_id, user_id)
);