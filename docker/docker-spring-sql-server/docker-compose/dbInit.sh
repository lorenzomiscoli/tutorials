#!/bin/bash
/opt/mssql-tools/bin/sqlcmd -S sql-server -U sa -P "$DB_PWD" -d master -i docker-entrypoint-initdb.d/init.sql
echo "All done!"
