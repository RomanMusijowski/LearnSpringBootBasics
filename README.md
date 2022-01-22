##### Running command to run docker container with postgreSQL database
### Execute in terminal
```dockerfile

docker pull postgres
docker run -d --name learnSpring -e POSTGRES_USER=dev -e POSTGRES_PASSWORD=dev -e POSTGRES_DB=learnSpring --port 5432:5432 postgres
```


ec2 virtual mashine 

kubernetes cluser (sth big) 
    it contains a lot of nodes
        can run a lot of pods/containers


Create Pull Request (new code)
    Resolve conflicts
        Run CI/CD (on Jenkins, Github, Gitlab) run unit/integration tests "mvn clean package"
            Code review (somebody checks your code)
            Refactor (your code updates)
                Get approve
                    Merge
        

