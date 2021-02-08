-- Deploy bootcamp_db:users to pg
-- requires: appschema

BEGIN;

CREATE TABLE bootcamp.users (
    id                  SERIAL                          PRIMARY KEY,
    name                TEXT                            NOT NULL,
    email               TEXT                            NOT NULL,
    access_token        TEXT                            NOT NULL,
    expired_on          TIMESTAMP WITH TIME ZONE        NOT NULL        DEFAULT CURRENT_TIMESTAMP
);
GRANT USAGE ON SEQUENCE bootcamp.users_id_seq  TO plutus_dev;

COMMIT;
