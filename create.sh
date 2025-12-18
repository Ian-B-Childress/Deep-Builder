#!/bin/bash
export PGPASSWORD='Jaggar2006'
BASEDIR=$(dirname $0)
DATABASE=deep_builder
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql"
