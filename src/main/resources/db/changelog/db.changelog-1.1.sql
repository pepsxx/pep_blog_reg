--liquibase formatted sql
--changeset pep_sxx:1
INSERT INTO user_role (id, name)
VALUES (0, 'ROLE_ADMIN'),
       (1, 'ROLE_USER');

--changeset pep_sxx:2
INSERT INTO "user" (name, email, pass, role_id)
VALUES ('Bob', 'bob@mail.ru', 'D/4avRoIIVNTwjPW4AlhPpXuxCU4Mqdhryj/N6xaFQw=', 0),
       ('Tom', 'tom@mail.ru', 'D/4avRoIIVNTwjPW4AlhPpXuxCU4Mqdhryj/N6xaFQw=', 1);