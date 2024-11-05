--liquibase formatted sql
--changeset pep_sxx:1
INSERT INTO role (id, name)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

--changeset pep_sxx:2
INSERT INTO "user" (name, email, pass, role_id)
VALUES ('Bob', 'bob@mail.ru', 'D/4avRoIIVNTwjPW4AlhPpXuxCU4Mqdhryj/N6xaFQw=', 1),
       ('Tom', 'tom@mail.ru', 'D/4avRoIIVNTwjPW4AlhPpXuxCU4Mqdhryj/N6xaFQw=', 2);