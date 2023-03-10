package com.ayesha.judicial_provision.User_Portal;

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


public class Cases extends AppCompatActivity {
    EditText caseNo, lawRef, sub, regBy, desc, otherRef, assignedLawyer;
    Button ok;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_case);

        lawRef = (EditText) findViewById(R.id.edtLawreference);
        assignedLawyer = (EditText) findViewById(R.id.edtAssignedLawyer);
        regBy = (EditText) findViewById(R.id.edtRegisteredBy);
        otherRef = (EditText) findViewById(R.id.edtOtherRef);
        caseNo = (EditText) findViewById(R.id.edtCaseNo);
        sub = (EditText) findViewById(R.id.edtsubject);
        desc = (EditText) findViewById(R.id.edtDesp);
        ok = (Button) findViewById(R.id.sbmit);

        final database lawhelper =
                new database (this);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cn = caseNo.getText().toString();
                String sb = sub.getText().toString();
                String des = desc.getText().toString();
                String rg=regBy.getText().toString();
                String lawRf=lawRef.getText().toString();
                String othRef=otherRef.getText().toString();
                String aLawyer=assignedLawyer.getText().toString();

                db = lawhelper.getWritableDatabase();
                if(cn.isEmpty() && sb.isEmpty() && des.isEmpty() && rg.isEmpty() &&
                        lawRf.isEmpty() && othRef.isEmpty() && aLawyer.isEmpty()){
                    Toast.makeText(Cases.this ,"Fill the form please!",Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty() && sb.isEmpty() && des.isEmpty() && rg.isEmpty() && lawRf.isEmpty()){
                    Toast.makeText(Cases.this ,"caseNo,subject,description" +
                            ",registeredby and lawReference should not empty!",Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty() && rg.isEmpty() && des.isEmpty()){
                    Toast.makeText(Cases.this ,"case Nummber ,description and " +
                            "registered by should not empty!",Toast.LENGTH_LONG).show();
                }
                else {
                    insertcases(cn, sb, des, rg, lawRf, aLawyer, othRef);
                    Intent activity = new Intent(Cases.this, UserPage.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Cases.this.startActivity(activity);

                }
            }

        });
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(Cases.this,UserPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
    public void insertcases(String cn, String sb, String des, String rg,
                            String lawRf, String aLawyer,String othRef) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(database.caseno,cn);
        contentValues.put(database.registerby, rg);
        contentValues.put(database.casesubject, sb);
        contentValues.put(database.descriptioncases, des);
        contentValues.put(database.lawno,lawRf);
        contentValues.put(database.otherref,othRef);
        contentValues.put(database.assignedlawyer,aLawyer);


        long id = db.insert(database.cases_table_name,
                null, contentValues);


    }
}