#!/bin/bash

set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE TABLE news_type (
        name text not null,
        color text,
        id bigserial primary key
    );
    CREATE TABLE news (
        name text not null,
        type_id bigint not null references news_type(id) on delete restrict on update cascade,
        about_short text,
        about_full text,
        id bigserial primary key
    );
EOSQL
