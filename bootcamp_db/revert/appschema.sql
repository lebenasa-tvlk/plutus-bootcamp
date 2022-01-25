-- Revert bootcamp_db:appschema from pg

BEGIN;

-- XXX Add DDLs here.
DROP SCHEMA bootcamp;

COMMIT;
