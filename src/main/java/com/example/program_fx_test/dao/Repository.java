package com.example.program_fx_test.dao;

import com.example.program_fx_test.Utils;
import com.example.program_fx_test.entities.Roles;
import com.example.program_fx_test.entities.User;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Repository {


    public void createTabeles() throws SQLException, ClassNotFoundException {
        String createStatement = """
                CREATE TABLE users (
                  id INT AUTO_INCREMENT PRIMARY KEY,
                  login VARCHAR(50) NOT NULL,
                  password VARCHAR(50) NOT NULL,
                  role VARCHAR(50) NOT NULL,
                  name VARCHAR(50) NOT NULL,
                  surname VARCHAR(50) NOT NULL
                );
                """;

        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(createStatement);
        preparedStatement.executeUpdate();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Repository repository = new Repository();
        try {
            repository.createTabeles();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUser(User user) throws SQLException, ClassNotFoundException {
        try {
            if (Utils.hasEmptyFields(user)) {
                throw new NullPointerException();
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        String insertStatement = "INSERT INTO users" +
                "(login, password, role, name, surname) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(insertStatement);
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getRole().toString());
        preparedStatement.setString(4, user.getName());
        preparedStatement.setString(5, user.getSurname());


        preparedStatement.executeUpdate();

    }

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = Database.getDbConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"));
                switch (resultSet.getString("role")) {
                    case "DEKAN" -> user.setRole(Roles.DEKAN);
                    case "TEACHER" -> user.setRole(Roles.TEACHER);
                    case "STUDENT" -> user.setRole(Roles.STUDENT);
                }
                users.add(user);
            }
        }
        return users;
    }




    public boolean checkUser(User user) throws SQLException, ClassNotFoundException {
        String checkStatement = "SELECT * FROM users WHERE login = '" + user.getLogin() + "'";
        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(checkStatement);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String login = resultSet.getString(2);
            String password = resultSet.getString(3);
            if (Objects.equals(user.getPassword(), password)) return true;

        }
        resultSet.close();
        return false;

    }

    public boolean checkUserIfExist(User user) throws SQLException, ClassNotFoundException {
        String checkStatement = "SELECT * FROM users WHERE login = '" + user.getLogin() + "'";
        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(checkStatement);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            resultSet.close();
            return true;
        } else {
            resultSet.close();
            return false;
        }
    }

    public User getUser(String login) throws SQLException, ClassNotFoundException {
        String checkStatement = "SELECT * FROM users WHERE login = '" + login + "'";
        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(checkStatement);
        ResultSet resultSet = preparedStatement.executeQuery();
        User userFromDB = null;
        while (resultSet.next()) {
            userFromDB = new User(resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(5),
                    resultSet.getString(6));
            switch (resultSet.getString("role")) {
                case "DEKAN" -> userFromDB.setRole(Roles.DEKAN);
                case "TEACHER" -> userFromDB.setRole(Roles.TEACHER);
                case "STUDENT" -> userFromDB.setRole(Roles.STUDENT);
            }
        }
        resultSet.close();
        return userFromDB;

    }

    public void deleteUser(User user) throws SQLException, ClassNotFoundException {
        String deleteStatement = "DELETE FROM users where login=?";
        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(deleteStatement);
        preparedStatement.setString(1,user.getLogin());
        preparedStatement.executeUpdate();

    }

    public List<User> getStudetsList() throws SQLException, ClassNotFoundException {

        List<User> listUsers = new ArrayList<>();
        String getStudentsStatement = "SELECT * FROM users WHERE role = 'STUDENT'";
        PreparedStatement preparedStatement = Database.getDbConnection().prepareStatement(getStudentsStatement);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            User user = new User(resultSet.getString(2), resultSet.getString(3));
            listUsers.add(user);
        }

        return listUsers;


    }
}
