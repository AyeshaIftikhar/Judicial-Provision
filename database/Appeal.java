package com.ayesha.judicial_provision.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Appeal extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "JD_PROVISION_DB";
    public static final String table_name ="Appeal_table";
    private static final int databse_version=1;
    public static String  idappeal="ID", appealto="Appeal_to", appealfrom="Appeal_From", caseno="Case_No ",
            subject="Subject", description="Description", date="Date";




    public Appeal(Context context) {
        super(context, DATABASE_NAME, null, databse_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =  "CREATE TABLE " + table_name+ "( " + idappeal + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+appealto+" TEXT,"+appealfrom+" TEXT ," + caseno +" INTEGER,"+subject+" TEXT," +
                description + " TEXT,"+date+" TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+table_name);
        onCreate(sqLiteDatabase);
    }
}
