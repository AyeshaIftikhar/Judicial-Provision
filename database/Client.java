package com.ayesha.judicial_provision.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Client extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "JD_PROVISION_DB";
    public static final String table_name ="Client_table";
    private static final int databse_version=1;
    public static String  clientid="ID", clientname="Client_Name", phone="Phone", email="Email",
            address="Address", dateofadding="Date_of_Adding";



    public Client(Context context) {
        super(context, DATABASE_NAME, null, databse_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =  "CREATE TABLE " + table_name+ "( " + clientid + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+clientname+" TEXT,"+phone+" INTEGER ,"+email+" TEXT," + address +
                " TEXT,"+dateofadding+" TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+table_name);
        onCreate(sqLiteDatabase);
    }
}

