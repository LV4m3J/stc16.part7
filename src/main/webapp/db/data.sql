CREATE TABLE STUDENTS.PUBLIC.person
(
    id         INT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(250),
    birth_date LONG(250)
);

create table STUDENTS.PUBLIC.users
(
    id      INT          NOT NULL AUTO_INCREMENT,
    login   VARCHAR(250) NOT NULL,
    pass    VARCHAR(250) NOT NULL,
    roles_id INT         NOT NULL
);

create table STUDENTS.PUBLIC.roles
(
    id        INT          NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(250) NOT NULL
);

insert into STUDENTS.PUBLIC.roles(role_name) values ('admin');
insert into STUDENTS.PUBLIC.roles(role_name) values ('user');

insert into STUDENTS.PUBLIC.users(login,pass,roles_id) values ('admin','admin1',1);
insert into STUDENTS.PUBLIC.users(login,pass,roles_id) values ('user1','user1',2);
insert into STUDENTS.PUBLIC.users(login,pass,roles_id) values ('user2','user2',2);