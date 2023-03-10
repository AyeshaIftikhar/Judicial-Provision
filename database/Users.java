package com.ayesha.judicial_provision.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Users extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "JD_PROVISION_DB";
    public static final String table_name ="Users_table";
    private static final int databse_version=1;
    public static String  idusers="ID", username="User_Name", address="Address", phone="Phone_no",
            email="Email", password="Password", dateofcreation="Date_of_creation";



    public Users(Context context) {
        super(context, DATABASE_NAME, null, databse_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =  "CREATE TABLE " + table_name+ "( " + idusers + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+username+" TEXT,"+address+" TEXT ,"+phone+" TEXT," + email + " TEXT,"+password+" TEXT,"+
                dateofcreation+" TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+table_name);
        onCreate(sqLiteDatabase);
    }
}
