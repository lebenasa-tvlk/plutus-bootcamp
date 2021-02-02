-- Revert bootcamp_db:refer_users_to_links from pg

BEGIN;

ALTER TABLE bootcamp.links DROP CONSTRAINT IF EXISTS fk_link_created_by;
ALTER TABLE bootcamp.links DROP CONSTRAINT IF EXISTS fk_link_updated_by;

COMMIT;
