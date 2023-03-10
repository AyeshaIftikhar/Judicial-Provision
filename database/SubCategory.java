package com.ayesha.judicial_provision.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.ayesha.judicial_provision.Laws.CyberLawsCategories;

public class SubCategory extends SQLiteOpenHelper {
    static String DATABASE_NAME="JD_PROVISION_DB";
    public static final String KEY_ID="id";
    public static final String SUB_CATEGORY_TABLE="SubCategoryTable";
    public static final String SUB_CATEGORY_Name="Sub_Category_name";
    public static final String CATEGORY_Name="Category_name";
    private static final int databse_version=1;

    public SubCategory(Context context) {
        super(context,DATABASE_NAME,null,databse_version);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE "+SUB_CATEGORY_TABLE+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"  +
                ""+SUB_CATEGORY_Name+" TEXT, "+CATEGORY_Name+" TEXT)";

        database.execSQL(CREATE_TABLE);
        Log.d("Table","CREATE TABLE "+SUB_CATEGORY_TABLE+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+SUB_CATEGORY_Name+" TEXT, "+CATEGORY_Name+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+SUB_CATEGORY_TABLE);

        onCreate(db);

    }

    public boolean addCybercategory(Context c){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(CATEGORY_Name,"Cyber");
        cv.put(SUB_CATEGORY_Name,"False Information");
        long result=db.insert(SUB_CATEGORY_TABLE,CATEGORY_Name,cv);
        db.close();

        if (result == -1 ) {
            Toast.makeText(c, "data not Inserted", Toast.LENGTH_SHORT).show();
            return false;
        }

        else {
            Toast.makeText(c, "data Inserted", Toast.LENGTH_SHORT).show();

            return true;

        }
    }

    public boolean addCivilCategory(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(SUB_CATEGORY_Name,"Dishonest Investigation");
        cv.put(CATEGORY_Name,"civil");
        long result= db.insert(SUB_CATEGORY_TABLE,null,cv);
        if(result==-1)
            return true;
        else
            return false;
    }




}
