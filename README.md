# Plutus Backend Bootcamp

Let's get to know the stacks used in Plutus' projects by doing little exercises.

> This folder contains the backend side of the bootcamp.

## Goal
Make a web app to store and manage links to internal content and documentations.

## Tasks
Feel free to mark these tasks as done on your branch/fork:
- [ ] Health check endpoint `/healthcheck`
- [ ] RESTful API to add/update/remove links to internal content and docs
- [ ] Setup a Postgres DB in Docker (see example on [mf-collection-service](https://github.com/traveloka/mf-collection-service))
- [ ] Build DB schema with `sqitch`
- [ ] Generate ORM with `jooq`

### Extra miles
- Cache response with `redis` and cachebust on an update
- User management (for example, store session and email in DB and obtain credentials from Auth0 at front-end side)
- Content management (add API as necessary to write contents)