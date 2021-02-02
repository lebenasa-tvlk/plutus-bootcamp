-- Verify bootcamp_db:appschema on pg

BEGIN;

-- XXX Add verifications here.
SELECT pg_catalog.has_schema_privilege('bootcamp', 'usage');

ROLLBACK;
