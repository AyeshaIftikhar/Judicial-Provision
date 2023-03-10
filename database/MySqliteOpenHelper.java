package com.ayesha.judicial_provision.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteOpenHelper extends SQLiteOpenHelper {

    private static final  String DATABASE_NAME = "JD_PROVISION_DB";
    public static final String table_name ="Admin_table";
    private static final int databse_version=1;
    public static String  idadmin="id", adminname="username", password="Password", admincontact="Phone_no";

    public MySqliteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, databse_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =  "CREATE TABLE " + table_name+ "( " + idadmin + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+adminname+" TEXT,"+password+" TEXT ,"+admincontact+" TEXT)";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+table_name);
        onCreate(sqLiteDatabase);
    }
}
