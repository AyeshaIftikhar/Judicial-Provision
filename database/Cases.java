package com.ayesha.judicial_provision.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Cases extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "JD_PROVISION_DB";
    public static final String table_name ="Cases_table";
    private static final int databse_version=1;
    public static String  idcases="ID", caseno="Case_No", casesubject="Case_subject",
            registerby="Registering_by", description="Description",otherref="Other_ref",
            assignedlawyer="Assigned_Lawyer", lawno="Law_no", casenature="Case_Nature";




    public Cases(Context context) {
        super(context, DATABASE_NAME, null, databse_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =  "CREATE TABLE " + table_name+ "( " + idcases + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +caseno+" INTEGER,"+registerby+" INTEGER  ,"+casesubject+" TEXT,"+description+" TEXT,"+lawno+" " +
                "INTEGER," + otherref + " TEXT,"+assignedlawyer+" TEXT,"+casenature+" TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+table_name);
        onCreate(sqLiteDatabase);
    }
}
