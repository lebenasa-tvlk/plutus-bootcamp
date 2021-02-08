-- Deploy bootcamp_db:links to pg
-- requires: appschema

BEGIN;

CREATE TABLE bootcamp.links (
    id              SERIAL                          PRIMARY KEY,
    link            TEXT                            NOT NULL,
    description     TEXT                            NOT NULL,
    status          SMALLINT                        NOT NULL    DEFAULT 0,
    created_by      INTEGER                         NOT NULL,
    created_on      TIMESTAMP WITH TIME ZONE        NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    updated_by      INTEGER,
    updated_on      TIMESTAMP WITH TIME ZONE
);
GRANT USAGE ON SEQUENCE bootcamp.links_id_seq  TO plutus_dev;

COMMIT;
