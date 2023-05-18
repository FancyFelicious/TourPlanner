-- 2do: needed? create tables with jpa instead?

-- ADD 'PGCRYPTO' EXTENSION FOR PASSWORD ENCRYPTION AND CONFIRM INSTALLATION WAS SUCCESSFUL--
create extension if not exists "pgcrypto";
select *
from pg_extension
where extname = 'pgcrypto';

-- DROP EXISTING TABLES --
drop table if exists users cascade;

-- CREATE TABLES / RELATIONS --
create table if not exists users
(
    id         SERIAL primary key,
    username   VARCHAR(50)  not null unique,
    password   VARCHAR(255) not null,
    name       VARCHAR(80)  not null default '-',
    created_at TIMESTAMP    not null default now()
);

-- username      VARCHAR(50)  not null unique,
-- bio           VARCHAR(500) not null default '-',
-- created_at    TIMESTAMP  not null default now()
-- user_id       INTEGER primary key references users (id),
