## PostgreSQL / PSQL
### Setup / Installation

#### Linux
##### 1. Install PostgreSQL
```sh  
$ sudo apt update
$ sudo apt install postgresql postgresql-contrib
$ sudo systemctl start postgresql.service
```
##### 2. Check status
```sh  
$ service postgresql start/stop/status
```
##### 3. Become 'postgres' user (if not already) and start interactive shell:
```sh
$ sudo -u postgres -i
```
###### List all running Postgres services
```sh
ps -f -u postgres
```
###### Show TCP/IP addresses and ports PostgreSQL is listening to
```sh
$ sudo lsof -n -u postgres | grep LISTEN
```

#### Windows
##### 1. Install PostgreSQL
- Download: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
- Install and set credentials
- Add environment variable to `PATH`, e.g.: `C:\Program Files\PostgreSQL\15\bin`
- Set `PGDATA` environment variable, e.g.: `C:\Program Files\PostgreSQL\15\data`

##### 2. Check status
```sh
$ pg_ctl start/stop/status
```
### Commands

#### Login to PostgreSQL console with 'postgres' user:
```sh
$ psql -U postgres
```
<sub>Standard password (set during installation): `password`</sub>

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

## Git
 - Add SSH key
 - Init repo locally
 - Create repo on GitHub -> follow instructions
 - GitHub Desktop?
  github desktop


## Maven / Compile

###### Compile / Build
```sh
$ mvn clean install
```
###### Force update snapshots (e.g. when adding new dependency)
```sh
$ mvn clean install -U
```
###### Run / Execute
```sh
$ mvn exec:java
```
### Other
###### Edit `resolv.conf` and set `nameserver` to `8.8.8.8` to resolve addresses / access internet in WSL
```sh
$ sudo vim /etc/resolv.conf
```

## JavaFX

## JUnit

## Other