create table if not exists users (
    username varchar(20) not null primary key,
    password varchar(100) not null,
    enabled boolean not null
    );

create table if not exists authorities (
    username varchar(20) not null,
    authority varchar(20) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
    );


create table if not exists questions (
    id identity,
    title varchar(60) not null,
    body varchar(400) not null
    );

create table if not exists Film (
    id identity,
    title varchar(60) not null,
    rating int,
    watched bit,
    comments varchar(400) not null
    );