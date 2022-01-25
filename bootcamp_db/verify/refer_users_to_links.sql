-- Verify bootcamp_db:refer_users_to_links on pg

BEGIN;

SELECT conname FROM pg_constraint WHERE conname IN ('fk_link_created_by', 'fk_link_updated_by');

ROLLBACK;
