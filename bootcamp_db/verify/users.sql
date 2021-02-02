-- Verify bootcamp_db:users on pg

BEGIN;

SELECT pg_catalog.has_table_privilege('bootcamp.users', 'select');

ROLLBACK;
