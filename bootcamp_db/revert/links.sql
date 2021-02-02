-- Revert bootcamp_db:links from pg

BEGIN;

DROP TABLE bootcamp.links;

COMMIT;
