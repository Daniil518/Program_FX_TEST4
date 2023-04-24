package com.example.program_fx_test.dao;
import com.example.program_fx_test.Const;

import java.sql.*;

public class Database extends Configs {

    public static Connection getDbConnection()
            throws ClassNotFoundException,SQLException{
        Class.forName(Const.dbClass);
        return DriverManager.getConnection(
                Const.dburl,Const.dbUser,Const.dbPassword);
    }

}
