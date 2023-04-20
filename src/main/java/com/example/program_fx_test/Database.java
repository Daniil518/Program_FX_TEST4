package com.example.program_fx_test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Database extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException,SQLException{
           String connectionString = "jdbc:mysql://" + dbHost + ":"
                   + dbPort + "/" + dbName;

           Class.forName("com.mysql.jdbc.Driver");

           dbConnection = DriverManager.getConnection(connectionString,
                   dbUser , dbPass);

           return dbConnection;
    }

    public void signUpUser(String Student, String Teacher, String Dekan) {
    String insert = "INSERT INTO" + Const.User_Table + "(" +
            Const.User_Student + "," + Const.User_Teacher + "," +
            Const.User_Dekan + ")" + "VALUES(?,?,?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, Student);
            prSt.setString(2, Teacher);
            prSt.setString(3, Dekan);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
