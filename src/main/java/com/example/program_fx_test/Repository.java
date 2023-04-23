package com.example.program_fx_test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Repository {


    public void createTabeles(){
        String createStatement = """
                CREATE TABLE users (
                  id INT PRIMARY KEY,
                  login VARCHAR(50) NOT NULL,
                  password VARCHAR(50) NOT NULL,
                  role VARCHAR(50) NOT NULL
                );
                """;

        try {
            PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(createStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Repository repository = new Repository();
        repository.createTabeles();
    }

    public void createUser(User user) {
        String insertStatement = "INSERT INTO users" +
                "(login, password, role) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(insertStatement);
//            preparedStatement.setString(1, );
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void checkUser(User user){
    }

    public void deleteUser(User user){

    }
}
