


#### Login to PostgreSQL console with 'postgres' user:

```sh
$ psql -U postgres
```

## PostgreSQL / PSQL

#### Login to PostgreSQL console with 'postgres' user:

```sh
$ psql -U postgres
```

#### Database management

##### View DBs

```sh
\l
```

##### View currently connected DB

```sh
SELECT current_database();
```

##### View tables

```sh
$ \d
```

##### Connect to different database

```sh
\c database_name
```

##### Create new database

```sh
$ CREATE DATABASE database;
```

##### Set Database Owner:

```sh
$ ALTER DATABASE database_name OWNER TO user;
```

##### Change schema name:

```sh
$ ALTER SCHEMA schema_name RENAME TO new_schema_name;
```

#### User management

##### List users / roles

```sh
\du+
```

##### View current user

```sh
SELECT current_user;
```

##### Reset password

```sh
$ ALTER USER username WITH PASSWORD 'new_password';
```

##### Create a Postgres user with all privileges (like initial 'postgres' user)

```sh
$ CREATE USER username WITH SUPERUSER CREATEDB CREATEROLE REPLICATION BYPASSRLS PASSWORD 'password';
```

##### Grant all privileges to a user

```sh
$ GRANT ALL PRIVILEGES ON DATABASE database TO username;
```

##### Exit PostgreSQL console

```sh
\q
```

## Maven / Compile

###### Compile / Build

```sh
$ mvn clean install
```

###### Run / Execute

```sh
$ mvn exec:java
```

###### JavaFX Run

```sh
$ mvn clean javafx:run   
```

###### Force update snapshots (e.g. when adding new dependency)

```sh
$ mvn clean install -U
```

###### Validate plugins - set verbosity (verbose, brief, default)

```sh
$ mvn clean install -Dmaven.plugin.validation=verbose
```

## IntelliJ

- Install 'Gluon' extension
