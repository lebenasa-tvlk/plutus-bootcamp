-- Deploy bootcamp_db:appschema to pg

BEGIN;

CREATE SCHEMA bootcamp;

GRANT USAGE ON SCHEMA bootcamp TO plutus_dev;
ALTER DEFAULT PRIVILEGES IN SCHEMA bootcamp GRANT INSERT, SELECT, UPDATE, DELETE ON TABLES TO plutus_dev;

COMMIT;
