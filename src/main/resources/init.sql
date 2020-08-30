create schema if not exists thesarius;
create extension if not exists "uuid-ossp";

create table thesarius.word
(
    id    uuid not null,
    greek text not null,
    rus   text,
    forms jsonb,

    constraint pk_user primary key (id)
);
