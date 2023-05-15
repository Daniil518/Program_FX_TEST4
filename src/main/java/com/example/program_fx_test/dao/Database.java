package com.example.program_fx_test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database extends Configs {

    public static Connection getDbConnection()
            throws ClassNotFoundException,SQLException{
        Class.forName(dbClass);
        return DriverManager.getConnection(
                dbUrl,dbUser,dbPass);
    }

}
