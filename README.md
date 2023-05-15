# JavafxApplication
## Build

Set JAVA_HOME env to JDK 1.8 and install maven 
```bash
mvn clean install 
```

You need to have instanse of Mysql db on or pc and set right configs in `com.example.program_fx_test.dao.Configs` 

If yoy have docker-compose installed on yor pc you can use yaml file in project root 

To prepare db and test connection you can execute `com/example/program_fx_test/dao/Repository.java:34`. That will produce creating tables for application.

After that you can run 
```bash
mvn clean javafx:run
```