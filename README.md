# Tour Planner
<p align="center"><b>
💎 🔥 ✨ Raza Ghulam ❤️ Felix Piber ✨ 🔥 💎
  </b></p>

[Link to GitHub Repository](https://github.com/FancyFelicious/TourPlanner)

---

## Setup / Installation - PostgreSQL

### Docker *(recommended)*

```sh  
$ docker-compose up -d
```

---

### Linux

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

##### Additional commands / Troubleshooting:

###### List all running Postgres services

```sh
ps -f -u postgres
```

###### Show TCP/IP addresses and ports PostgreSQL is listening to

```sh
$ sudo lsof -n -u postgres | grep LISTEN
```

---

### Windows

##### 1. Install PostgreSQL

- Download: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
- Install and set credentials during installation process
- Set `PGDATA` environment variable, e.g.: `C:\Program Files\PostgreSQL\15\data`
- Add environment variable to `PATH`, e.g.: `C:\Program Files\PostgreSQL\15\bin`

##### 2. Check status

```sh
$ pg_ctl start/stop/status
```

---
