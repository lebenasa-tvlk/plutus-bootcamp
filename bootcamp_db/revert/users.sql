-- Revert bootcamp_db:users from pg

BEGIN;

DROP TABLE bootcamp.users;

COMMIT;
