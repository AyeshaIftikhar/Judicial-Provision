package com.ayesha.judicial_provision.Admin_Portal;

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


public class Update extends AppCompatActivity {
    private SQLiteDatabase db;
    EditText lawnameetup,subjectetup,descriptionetup,conditionetup,paneltyetup,dateetup,lawidetup;
    Button updatebtn;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_data);

        lawidetup = (EditText) findViewById(R.id.lawidetup);
        lawnameetup = (EditText) findViewById(R.id.lawnameetup);
        subjectetup = (EditText) findViewById(R.id.subjectetup);
        descriptionetup = (EditText) findViewById(R.id.descriptionetup);
        conditionetup = (EditText) findViewById(R.id.conditionetup);
        paneltyetup = (EditText) findViewById(R.id.paneltyetup);
        dateetup = (EditText) findViewById(R.id.dateetup);
        updatebtn = (Button) findViewById(R.id.nextbtn1);

        final database lawhelper = new database(this);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = lawidetup.getText().toString();
                String lawname1up = lawnameetup.getText().toString();
                String subject2up = subjectetup.getText().toString();
                String description3up = descriptionetup.getText().toString();
                String condition4up = conditionetup.getText().toString();
                String panelty5up = paneltyetup.getText().toString();
                String date6up = dateetup.getText().toString();
                db = lawhelper.getWritableDatabase();
                if(id.isEmpty() && lawname1up.isEmpty() && subject2up.isEmpty() &&
                        description3up.isEmpty() && condition4up.isEmpty() && panelty5up.isEmpty() &&
                        date6up.isEmpty()){
                    Toast.makeText(Update.this, "Fill the form comletely",Toast.LENGTH_LONG).show();
                }
                else if(lawname1up.isEmpty()){
                    Toast.makeText(Update.this, "Law name is required!",Toast.LENGTH_LONG).show();
                }
                else {
                    updateData(id, lawname1up, subject2up, description3up, condition4up, panelty5up, date6up);
                    Toast.makeText(getApplicationContext(), "Data Updated Succesfully",
                            Toast.LENGTH_SHORT).show();
                    Intent activity = new Intent(Update.this, AddReference.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Update.this.startActivity(activity);
                   // finish();
                }

            }
            public void updateData(String id, String lawname1up, String subject2up, String description3up,
                                   String condition4up, String panelty5up, String date6up){
                ContentValues contentValues = new ContentValues();
                SQLiteDatabase db = lawhelper.getWritableDatabase();
              //  contentValues.put(database.Key_Law_Number, ref_id);
                contentValues.put(database.LAW_Name, lawname1up);
                contentValues.put(database.KEY_Subject, subject2up);
                contentValues.put(database.Key_Description, description3up);
                contentValues.put(database.Key_Condition, condition4up);
                contentValues.put(database.Key_Panelty, panelty5up);
                contentValues.put(database.Key_Date, date6up);


                db.update(database.LAW_TABLE_NAME, contentValues, id+ "="+id, null);
            }

        });
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(Update.this, AdminProfile.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
