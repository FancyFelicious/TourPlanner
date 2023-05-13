-- ADD 'PGCRYPTO' EXTENSION FOR PASSWORD ENCRYPTION AND CONFIRM INSTALLATION WAS SUCCESSFUL--
-- Note: Double encryption removed in final assignment --
create extension if not exists "pgcrypto";
select *
from pg_extension
where extname = 'pgcrypto';

-- DROP EXISTING TABLES --
drop table if exists users cascade;
drop table if exists stats cascade;
drop table if exists match_history cascade;
drop table if exists inventory cascade;

-- ADD TABLES / CREATE DATABASE LAYOUT --
create table if not exists users
(
    id            SERIAL primary key,
    username      VARCHAR(50)  not null unique,
    password      VARCHAR(255) not null,
    name          VARCHAR(80)  not null default '-',
    bio           VARCHAR(500) not null default '-',
    image         VARCHAR(100) not null default '-',
    session_token VARCHAR(50)  not null default '-',
    created_at    TIMESTAMP    not null default now()
);

create table if not exists stats
(
    user_id                INTEGER primary key references users (id),
    elo_score              INTEGER not null default 100,
    games_played           INTEGER not null default 0,
    win_ratio              FLOAT   not null default 0,
    achievement_1_progress INTEGER not null default 0,
    achievement_2_progress INTEGER not null default 0,
    achievement_3_progress INTEGER not null default 0,
    transaction_history    VARCHAR(1000)
);

create table if not exists match_history
(
    user_id    INTEGER primary key references users (id),
    enemy      INTEGER    not null references users (id),
    outcome    VARCHAR(5) not null,
    created_at TIMESTAMP  not null default now()
);

create table if not exists inventory
(
    user_id         INTEGER primary key references users (id),
    coins           INTEGER      not null default 20,
    card_collection VARCHAR(1000),
    battle_deck     VARCHAR(256),
    achievements    VARCHAR(100) not null default ''
);