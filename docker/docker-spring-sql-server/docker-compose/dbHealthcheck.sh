#!/bin/bash
if /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P "$DB_PWD" -Q 'SELECT 1'; then
    exit 0  # Exit with code 0 for success
else
    exit 1  # Exit with a non-zero code for failure
fi
