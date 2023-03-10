package com.ayesha.judicial_provision.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class References extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "JD_PROVISION_DB";
    public static final String table_name ="References_table";
    private static final int databse_version=1;
    public static String  id="ID",idreferences="ID_ref", authorname="Law_Name",date ="Date", book="BOOK",
            chapter="Chapter", page="Page" ;




    public References(Context context)
    {
        super(context, DATABASE_NAME, null, databse_version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =  "CREATE TABLE " + table_name+ "( " + id + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+idreferences+" TEXT,"+authorname+" TEXT ,"+book+" TEXT," + chapter + " TEXT,"+page+" TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+table_name);
        onCreate(sqLiteDatabase);
    }
}
