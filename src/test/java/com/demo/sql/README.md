## SQL

To run the SQL queries setup a postgres db and seed the test data


```bash
docker run -p 5432:5432 --name pg-container -e POSTGRES_PASSWORD=password -d postgres:9.6.10
docker ps
docker exec -it pg-container psql -U postgres -W postgres
CREATE USER test WITH PASSWORD 'test@123';
CREATE DATABASE "test-db" WITH OWNER "test" ENCODING UTF8 TEMPLATE template0;
grant all PRIVILEGES ON DATABASE "test-db" to test;
\c test-db

docker stop pg-container
docker start pg-container
```

[DB Seed Data SQL](https://github.com/gitorko/project01/blob/master/src/test/java/com/demo/sql/setup/setup.sql)
[Queries](https://github.com/gitorko/project01/blob/master/src/test/java/com/demo/sql/queries/employee-queries.sql)
