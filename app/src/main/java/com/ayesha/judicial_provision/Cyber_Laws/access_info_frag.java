package com.ayesha.judicial_provision.Cyber_Laws;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.ayesha.judicial_provision.Laws.CyberLawsCategories;
import com.ayesha.judicial_provision.Laws.SqLiteLawsAdapter;
import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.database;

public class access_info_frag extends Activity {
    SQLiteDatabase sqLiteDatabase;
    private database db;
    Cursor cursor;
    SqLiteLawsAdapter listAdapter;

    TextView lawNo,lawName,LawSub,lawDes,LawPanelty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laws_frag);

        lawNo=(TextView)findViewById(R.id.law_no);
        lawName=(TextView)findViewById(R.id.lawName);
        LawSub=(TextView)findViewById(R.id.law_subject);
        lawDes=(TextView)findViewById(R.id.law_desc);
        LawPanelty=(TextView)findViewById(R.id.law_panelty);

        db=new database(this);
        showLaws();

    }

    @Override
    protected void onResume() {
        // showLaws() ;
        super.onResume();
    }

    private void showLaws() {
        sqLiteDatabase = db.getWritableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM Laws_Table" +
                " where "+"Category=?  AND "+"Sub_Category_name=?",new String []{"Cyber","Access to information"});

        if (cursor.moveToFirst()) {
            do {
               // lawNo.setText(cursor.getString(cursor.getColumnIndex(db.Key_Law_Number)));
                lawName.setText(cursor.getString(cursor.getColumnIndex(db.LAW_Name)));
                LawSub.setText(cursor.getString(cursor.getColumnIndex(db.KEY_Subject)));
                lawDes.setText(cursor.getString(cursor.getColumnIndex(db.Key_Description)));
                LawPanelty.setText(cursor.getString(cursor.getColumnIndex(db.Key_Panelty)));


               /*lawDate.setText(cursor.getString(cursor.getColumnIndex(db.Key_Date)));
               String tmpStr = cursor.getString(cursor.getColumnIndex(db.Key_Date));
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dateVariable;
                dateVariable = sdf.parse(tmpStr);*/
            }
            while (cursor.moveToNext());
        }

        cursor.close();
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(access_info_frag.this, Access_Info.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
