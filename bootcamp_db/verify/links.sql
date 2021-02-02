-- Verify bootcamp_db:links on pg

BEGIN;

SELECT pg_catalog.has_table_privilege('bootcamp.links', 'select');

ROLLBACK;
