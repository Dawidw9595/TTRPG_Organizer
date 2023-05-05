package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class dbhelper extends OrmLiteSqliteOpenHelper {

    private static final String NAME = "TTRPG";
    private static final int databaseVersion = 1;

    public dbhelper(Context context){
        super(context, NAME, null, databaseVersion);
    }

    String url = "jdbc:postgresql://192.168.0.4:5432/TTRPG";

    JdbcConnectionSource connectionSource;
    {
        try {
            connectionSource = new JdbcConnectionSource(url,"postgres","12345");
        } catch (SQLException e) {
            Log.d("poloczenie" , "NIE");
        }
    }

    private Dao<user,Integer> uzytkownik;

    public Dao<user,Integer> getUzytkownik() throws SQLException{
        if (uzytkownik == null)
        {
            uzytkownik = getDao(user.class);
        }
        return uzytkownik;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,user.class);
        } catch (SQLException e) {
            Log.d("DODANIE" , "NIE");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, user.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.d("usuniecie" , "NIE");
        }
    }
}
