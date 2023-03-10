package com.ayesha.judicial_provision.Lawyers_Portal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.database;


public class HearingDate extends AppCompatActivity {
    Button ok;
    EditText caseNumber, date, summary;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hearing_date);
        caseNumber=(EditText)findViewById(R.id.casenum);
        date=(EditText)findViewById(R.id.NextDate);
        summary=(EditText)findViewById(R.id.hearingSummary);
        ok=(Button)findViewById(R.id.ok);
        final database lawhelper = new database(this);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cn = caseNumber.getText().toString();
                String cdate =date.getText().toString();
                String sum= summary.getText().toString();

                db = lawhelper.getWritableDatabase();
                if(cn.isEmpty() && cdate.isEmpty() && sum.isEmpty()){
                    Toast.makeText(HearingDate.this,
                            "Please Fill form completely",Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty() && cdate.isEmpty()){
                    Toast.makeText(HearingDate.this,
                            "case number and date is neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty() && sum.isEmpty()){
                    Toast.makeText(HearingDate.this,
                            "Case number and summary is neccessary!",Toast.LENGTH_LONG).show();
                }
                else if( cdate.isEmpty() && sum.isEmpty()){
                    Toast.makeText(HearingDate.this,
                            "date and summary is neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty()){
                    Toast.makeText(HearingDate.this,
                            "case number is neccessary!",Toast.LENGTH_LONG).show();
                }
                else if( cdate.isEmpty()){
                    Toast.makeText(HearingDate.this,
                            "case date is neccessary!",Toast.LENGTH_LONG).show();
                }
                else if( sum.isEmpty()){
                    Toast.makeText(HearingDate.this,
                            "Summary is neccessary!",Toast.LENGTH_LONG).show();
                }
                else {
                    addcasedata(cn, cdate, sum);
                    Intent activity = new Intent(HearingDate.this, LawyersPage.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    HearingDate.this.startActivity(activity);
                   // finish();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(HearingDate.this, LawyersPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }

    public void addcasedata(String cn, String cdate, String sum) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.caseno, cn);
        contentValues.put(database.dateofhearing, cdate);
        contentValues.put(database.shortsummaryofhearing, sum);

        db.insert(database.casesdata_table_name , null, contentValues);
    }
}
