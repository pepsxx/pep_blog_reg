--liquibase formatted sql

--changeset pep_sxx:1
INSERT INTO "user" (id, name, email, pass, data_time_registering)
VALUES (1, 'Bob', 'bob@mail.ru', 'D/4avRoIIVNTwjPW4AlhPpXuxCU4Mqdhryj/N6xaFQw=', now()),
       (2, 'Tom', 'tom@mail.ru', 'D/4avRoIIVNTwjPW4AlhPpXuxCU4Mqdhryj/N6xaFQw=', now());

--changeset pep_sxx:2
INSERT INTO role (ordinal, name)
VALUES (0, 'ROLE_ADMIN'),
       (1,'ROLE_USER');
--
-- --changeset pep_sxx:3
-- INSERT INTO roles_users (user_id, role_id)
-- VALUES (1,0),
--        (2,1);