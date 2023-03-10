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

public class addCase extends AppCompatActivity {
    EditText caseNo, Subject, descrption, nature;
    Button submit;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_case);
        caseNo=(EditText)findViewById(R.id.caseNo);
        Subject=(EditText)findViewById(R.id.caseSubject);
        descrption=(EditText)findViewById(R.id.caseDesc);
        nature=(EditText)findViewById(R.id.caseNature);
        submit=(Button)findViewById(R.id.submit);
        final database lawhelper = new database(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cno = caseNo.getText().toString();
                String csub =Subject.getText().toString();
                String cdesc = descrption.getText().toString();
                String cnat=nature.getText().toString();

                db = lawhelper.getWritableDatabase();
                if(cno.isEmpty() && csub.isEmpty() && cdesc.isEmpty() && cnat.isEmpty()){
                    Toast.makeText(addCase.this,"Please Fill form completely",
                            Toast.LENGTH_LONG).show();
                }
                else if(cno.isEmpty() && csub.isEmpty() && cdesc.isEmpty()){
                    Toast.makeText(addCase.this,"Please Fill the empty fields",
                            Toast.LENGTH_LONG).show();
                }
                else if(cno.isEmpty() && csub.isEmpty()){
                    Toast.makeText(addCase.this,"Please Enter case number and subject!",
                            Toast.LENGTH_LONG).show();
                }
                else if(cno.isEmpty() && cdesc.isEmpty()){
                    Toast.makeText(addCase.this,"Please Enter case number and description!",
                            Toast.LENGTH_LONG).show();
                }
                else if( csub.isEmpty() && cdesc.isEmpty()){
                    Toast.makeText(addCase.this,"Please Enter case subject and description!",
                            Toast.LENGTH_LONG).show();
                }
                else if(cno.isEmpty()){
                    Toast.makeText(addCase.this,"Please Enter case Nummber!",
                            Toast.LENGTH_LONG).show();
                }
                else if(csub.isEmpty()){
                    Toast.makeText(addCase.this,"Please Enter case subject!",
                            Toast.LENGTH_LONG).show();
                }
                else if(cdesc.isEmpty()){
                    Toast.makeText(addCase.this,"Please Enter case description!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    addcases(cno, csub, cdesc, cnat);
                    Intent activity = new Intent(addCase.this, LawyersPage.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    addCase.this.startActivity(activity);
                   // finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(addCase.this, LawyersPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }

    public void addcases(String cn, String csub, String cdesc, String cnat) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.caseno, cn);
        contentValues.put(database.casesubject, csub);
        contentValues.put(database.descriptioncases, cdesc);
        contentValues.put(database.casenature, cnat);
        db.insert(database.cases_table_name, null, contentValues);
    }
}
