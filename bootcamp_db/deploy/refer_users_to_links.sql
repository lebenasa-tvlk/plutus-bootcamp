-- Deploy bootcamp_db:refer_users_to_links to pg
-- requires: users
-- requires: links

BEGIN;

ALTER TABLE bootcamp.links ADD CONSTRAINT fk_link_created_by FOREIGN KEY (created_by) REFERENCES bootcamp.users(id);
ALTER TABLE bootcamp.links ADD CONSTRAINT fk_link_updated_by FOREIGN KEY (updated_by) REFERENCES bootcamp.users(id);

COMMIT;
