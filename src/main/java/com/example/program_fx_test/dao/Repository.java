package com.example.program_fx_test.dao;

import com.example.program_fx_test.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Repository {


    public void createTabeles() throws SQLException, ClassNotFoundException {
        String createStatement = """
                CREATE TABLE users (
                  id INT AUTO_INCREMENT PRIMARY KEY,
                  login VARCHAR(50) NOT NULL,
                  password VARCHAR(50) NOT NULL,
                  role VARCHAR(50)
                );
                """;

        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(createStatement);
        preparedStatement.executeUpdate();
    }

    public static void main(String[] args) {
        Repository repository = new Repository();
        try {
            boolean isUser =  repository.checkUser(new User("login", "password"));
            System.out.println(isUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUser(User user) throws SQLException, ClassNotFoundException {
        String insertStatement = "INSERT INTO users" +
                "(login, password, role) VALUES (?,?,?)";
        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(insertStatement);
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getRole().toString());

        preparedStatement.executeUpdate();

    }

    public boolean checkUser(User user) throws SQLException, ClassNotFoundException {
        String checkStatement = "SELECT * FROM users WHERE login = '"+user.getLogin()+"'";
        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(checkStatement);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String login = resultSet.getString(2);
            String password = resultSet.getString(3);
            System.out.println(Objects.equals(user.getPassword(), password));
            if(Objects.equals(user.getPassword(), password)) return true;

        }
        resultSet.close();
        return false;

    }

    public void deleteUser(User user){

    }
}
