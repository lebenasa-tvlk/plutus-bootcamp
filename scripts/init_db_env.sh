#!/bin/bash

db_main_user="plutus_dev"
db_users=("plutus_dev")
for db_user in "${db_users[@]}"; do
  docker exec -it postgresdb psql postgres -c "SELECT 1 FROM pg_roles WHERE rolname='$db_user';" | grep -q 1
  if [ $? ]; then
    docker exec -it postgresdb psql postgres -c "CREATE USER $db_user LOGIN NOCREATEDB NOCREATEROLE NOINHERIT NOSUPERUSER PASSWORD '$db_user';"
  fi
done

dbs=("bootcamp_db")
for db in "${dbs[@]}"; do
  if [ -z $( docker exec -it postgresdb psql postgres -lqt | cut -d \| -f 1 | grep -w $db ) ]; then
    docker exec -it postgresdb psql postgres -qc "GRANT $db_main_user to CURRENT_USER;"
    docker exec -it postgresdb psql postgres -qc "CREATE DATABASE $db OWNER $db_main_user;"
    docker exec -it postgresdb psql postgres -qc "REVOKE $db_main_user from CURRENT_USER;"
    # PGPASSWORD=$db_pass docker exec -it postgresdb psql -U root -d $db -h localhost -w -c "CREATE EXTENSION pgtap;"
    PGPASSWORD=$db_pass docker exec -it postgresdb psql -U root -d $db -h localhost -w -c "CREATE EXTENSION pg_trgm with schema pg_catalog;"
    printf "Database $db created.\n"
  else
    printf "Database $db already exists. Skipping DB creation task.\n"
  fi
done
