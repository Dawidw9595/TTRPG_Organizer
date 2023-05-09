package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class dbhelper extends OrmLiteSqliteOpenHelper {

    private static final String NAME = "TTRPG";
    private static final int databaseVersion = 1;

    private static final String POSTGRES_HOST="192.168.0.4";
    private static final int POSTGRES_PORT=5432;
    private static final String POSTGRES_USER="postgres";
    private static final String POSTGRES_PASSWORD="12345";

    private JdbcConnectionSource connectionSource =null;
    public dbhelper(Context context){
        super(context, NAME, null, databaseVersion);
        try {
            connectionSource=new JdbcConnectionSource(getUrl(),POSTGRES_USER,POSTGRES_PASSWORD);
            Log.d("poloczenie", "tak");
        } catch (SQLException e) {
            Log.e("poloczenie", "nie",e);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,user.class);
            Log.d("DatabaseHelper", "Tabele zostały utworzone pomyślnie.");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("DatabaseHelper", "Błąd podczas tworzenia tabel.", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource , user.class,true);
            Log.d("aaaaaaaaaab","tak");
        } catch (SQLException e) {
            Log.e("aaaaaaaaaab","nie",e);
        }
    }

    private String getUrl()
    {
        return "jdbc:postgresql://" + POSTGRES_HOST + ":" + POSTGRES_PORT + "/" + NAME;
    }

    public void close()
    {
        super.close();
        try{
            if(connectionSource !=null)
            {
                connectionSource.close();
                connectionSource=null;
            }
        } catch (IOException e) {
            Log.e("wyloczenie" , "nie" ,e);
        }
    }

}
