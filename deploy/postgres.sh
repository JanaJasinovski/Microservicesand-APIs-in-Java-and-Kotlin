#!/bin/bash
docker run --name pg-16.2 -p 5432:5432 \
    -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres \
    -v /srv/db/postgres:/var/lib/postgresql/data:rw \
    -d postgres:16.2
