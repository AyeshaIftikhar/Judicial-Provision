package com.ayesha.judicial_provision.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CasesData extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "JD_PROVISION_DB";
    public static final String table_name ="CasesData_table";
    private static final int databse_version=1;
    public static String  cdid="ID", dateofhearing="Date_of_Hearing", dateoftermination="Date_of_Termination",
            shortsummaryofhearing="Short_summary_of_hearing", summaryoftermination="Summary_of_termination",
            caseno="Case_no";




    public CasesData(Context context) {
        super(context, DATABASE_NAME, null, databse_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =  "CREATE TABLE " + table_name+ "( " + cdid + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+dateofhearing+" TEXT,"+dateoftermination+" TEXT ,"+shortsummaryofhearing+" TEXT," +
                summaryoftermination + " TEXT,"+caseno+" TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+table_name);
        onCreate(sqLiteDatabase);
    }
}
