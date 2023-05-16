package com.example.rollapp;

import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class poloczenie {

    private static final String user = "postgres";
    private static final String pass = "12345";
    private static  String url = "jdbc:postgresql://192.168.0.4:5432/TTRPG";

    private static  ConnectionSource connectionSource;
    private static boolean status;

    public poloczenie()
    {
        getconnection();
        System.out.println("Connection status: " + status);
    }

    public static ConnectionSource getconnection(){
        try {
            connectionSource = new JdbcConnectionSource(url,user,pass);
            status = true;
        } catch (SQLException e) {
            status = false;
            throw new RuntimeException(e);
        }
        return connectionSource;
    }

    public static void create() throws SQLException {
        TableUtils.createTableIfNotExists(getconnection(), user.class);
        TableUtils.createTableIfNotExists(getconnection(), mg.class);
    }

    public static void drop() throws SQLException{
        TableUtils.dropTable(getconnection(), user.class,true);
        TableUtils.dropTable(getconnection(), mg.class,true);
    }
}
