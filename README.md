##### Running command to run docker container with postgreSQL database
### Execute in terminal
```dockerfile

docker pull postgres
docker run -d --name learnSpring -e POSTGRES_USER=dev -e POSTGRES_PASSWORD=dev -e POSTGRES_DB=learnSpring -p 5432:5432 postgres
```
