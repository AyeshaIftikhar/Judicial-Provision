package com.ayesha.judicial_provision.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Lawyers extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "JD_PROVISION_DB";
    public static final String table_name ="Lawyers_table";
    private static final int databse_version=1;

    public static String  lawyerid="Lawyer_id",lawyerno="Lawyer_no", lawyername="Lawyer_Name"
            ,speciality="Speciality", phone="Phone", email="Email", address="Address", password="Password",
            dateofcreation="Date_of_creation";



    public Lawyers(Context context) {
        super(context, DATABASE_NAME, null, databse_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =  "CREATE TABLE " + table_name+ "( " + lawyerid + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+lawyerno+" INTEGER,"+lawyername+" TEXT ,"+speciality+" TEXT," + phone + " TEXT," + email +
                " TEXT,"+address+" TEXT," + password + " TEXT,"+dateofcreation+" TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+table_name);
        onCreate(sqLiteDatabase);
    }
}
