drop table if exists stc16.stc16servlets.person, stc16.stc16servlets.users, stc16.stc16servlets.roles cascade;
drop sequence if exists stc16.stc16servlets.person_id_seq, stc16.stc16servlets.users_id_seq, stc16.stc16servlets.roles_id_seq;

CREATE TABLE stc16.stc16servlets.person
(
    id         serial NOT NULL,
    name       VARCHAR(250),
    birth_date bigint
);

create table stc16.stc16servlets.users
(
    id      serial          NOT NULL,
    login   VARCHAR(250) NOT NULL,
    pass    VARCHAR(250) NOT NULL,
    roles_id INT         NOT NULL
);

create table stc16.stc16servlets.roles
(
    id        serial          NOT NULL,
    role_name VARCHAR(250) NOT NULL
);

insert into stc16.stc16servlets.roles(role_name) values ('admin');
insert into stc16.stc16servlets.roles(role_name) values ('user');

insert into stc16.stc16servlets.users(login,pass,roles_id) values ('admin','admin1',1);
insert into stc16.stc16servlets.users(login,pass,roles_id) values ('user1','user1',2);
insert into stc16.stc16servlets.users(login,pass,roles_id) values ('user2','user2',2);