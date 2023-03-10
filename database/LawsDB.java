package com.ayesha.judicial_provision.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LawsDB extends SQLiteOpenHelper {

    static String DATABASE_NAME="JD_PROVISION_DB";

    public static final String KEY_ID="id";
    public static final String TABLE_NAME="Laws_Table";
    public static final String KEY_Name="Law_name";
    public static final String KEY_Number="Law_number";
    public static final String KEY_Subject="subject";
    public static final String Key_Description="Description";
    public static final String Key_Condition="Condition";
    public static final String Key_Panelty="Panelty";
    public static final String key_Sub_Category="Sub_Category_name";
    public static final String Key_Date="Date";
    public static final String Key_Category="Category";

    public LawsDB(Context context1) {

        super(context1,DATABASE_NAME,null,2);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +KEY_Name+"TEXT," +
                ""+KEY_Number+" TEXT, "+KEY_Subject+" TEXT,"+Key_Description+" TEXT," +
                ""+Key_Condition+" TEXT,"+Key_Panelty+" TEXT,"+Key_Date+"TEXT,"+key_Sub_Category+"TEXT," +
                ""+Key_Category+"TEXT)";

        database.execSQL(CREATE_TABLE);
        Log.d("Table ","CREATE TABLE "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                " "+KEY_Name+"TEXT," +
                ""+KEY_Number+" TEXT, "+KEY_Subject+" TEXT,"+Key_Description+" TEXT," +
                ""+Key_Condition+" TEXT,"+Key_Panelty+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+TABLE_NAME);
        onCreate(db);
    }

    public void addCyberAct(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_Name," False Information ");
        cv.put(KEY_Subject,"Spreading False Information about an Individual");
        cv.put(Key_Description,"Whoever intentionally and publicly displays any" +
                " information through any information system,"+
                " which he knows to be false and intimidates or " +
                "harms the reputation or privacy of a natural person.");
        cv.put(Key_Panelty,"up to 3 Years in Prison or up to Rs. 1 Million in Fine or both");
        cv.put(key_Sub_Category,"False Information");
        cv.put(Key_Category,"Cyber");
        db.insert(TABLE_NAME,null,cv);
        db.close();
    }

    public void addFemaleProtectionLaws(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_Name," False Information ");
        cv.put(KEY_Subject,"Spreading False Information about an Individual");
        cv.put(Key_Description,"Whoever intentionally and publicly displays any" +
                " information through any information system,"+
                " which he knows to be false and intimidates or " +
                "harms the reputation or privacy of a natural person.");
        cv.put(Key_Panelty,"up to 3 Years in Prison or up to Rs. 1 Million in Fine or both");
        cv.put(key_Sub_Category,"False Information");
        cv.put(Key_Category,"FemaleProtectionAct");
        db.insert(DATABASE_NAME,null,cv);
        db.close();
    }

    public void addCivilLaws(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_Name," Dishonest or False Investigation ");
        cv.put(KEY_Number,"166B");
        cv.put(KEY_Subject,"Doing false Investigation");
        cv.put(Key_Description,"the court while concluding a trial of any offence will also clearly give findings whether " +
                "unvestigations are done fairly or honestly in accordance to fulfil laws all legal and procedural requirements " +
                "neccessary for such investigation or not. ");
        cv.put(Key_Panelty,"up to 3 Years in Prison or up to Rs. 1 Million in Fine or both");
        cv.put(key_Sub_Category,"Dishonest Investigation");
        cv.put(Key_Category,"CivilLaws");
        db.insert(DATABASE_NAME,null,cv);
        db.close();
    }

}
