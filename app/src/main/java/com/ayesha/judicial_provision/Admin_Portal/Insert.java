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

import static com.ayesha.judicial_provision.database.KEY_ID;
import static com.ayesha.judicial_provision.database.KEY_Subject;
import static com.ayesha.judicial_provision.database.Key_Category;
import static com.ayesha.judicial_provision.database.Key_Condition;
import static com.ayesha.judicial_provision.database.Key_Date;
import static com.ayesha.judicial_provision.database.Key_Description;
import static com.ayesha.judicial_provision.database.Key_Law_Number;
import static com.ayesha.judicial_provision.database.Key_Panelty;
import static com.ayesha.judicial_provision.database.LAW_Name;
import static com.ayesha.judicial_provision.database.key_Sub_Category;

public class Insert extends AppCompatActivity {
    private SQLiteDatabase db;
    EditText lawNo, lawname,subject,description,panelty,date, condition,category,subCategory;
    Button insertbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_data);

        category=(EditText)findViewById(R.id.iCategory);
        subCategory=(EditText)findViewById(R.id.isubCate);
        lawNo=(EditText)findViewById(R.id.lawNo);
        lawname = (EditText) findViewById(R.id.lawnameet);
        subject= (EditText) findViewById(R.id.subjectet);
        description = (EditText) findViewById(R.id.descriptionet);
        condition = (EditText) findViewById(R.id.conditionet);
        panelty = (EditText) findViewById(R.id.paneltyet);
        date = (EditText) findViewById(R.id.dateet);
        insertbtn = (Button) findViewById(R.id.inserdbbtn);

        final database lawhelper = new database(this);

        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String category= Insert.this.category.getText().toString();
                String scat=subCategory.getText().toString();
                String lawNum0=lawNo.getText().toString();
                String lawname1 = lawname.getText().toString();
                String subject2 = subject.getText().toString();
                String description3 = description.getText().toString();
                String condition4 = condition.getText().toString();
                String panelty5 = panelty.getText().toString();
                String date6 = date.getText().toString();
                db = lawhelper.getWritableDatabase();
                if(category.isEmpty() && scat.isEmpty() && lawNum0.isEmpty() && lawname1.isEmpty() && subject2.isEmpty() &&
                        description3.isEmpty() && condition4.isEmpty() && panelty5.isEmpty() && date6.isEmpty()){
                    Toast.makeText(Insert.this,"All details are required",Toast.LENGTH_LONG).show();
                }
                else if(category.isEmpty() && scat.isEmpty() && lawname1.isEmpty()){
                    Toast.makeText(Insert.this,"LawName , category and" +
                            " subcategory are neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(category.isEmpty() && scat.isEmpty()){
                    Toast.makeText(Insert.this,"category " +
                            "and subcategory arre required!",Toast.LENGTH_LONG).show();
                }
                else if(category.isEmpty() &&  lawname1.isEmpty()){
                    Toast.makeText(Insert.this,"LawName and category" +
                            " are neccessary!",Toast.LENGTH_LONG).show();
                }
                else if( scat.isEmpty() && lawname1.isEmpty()){
                    Toast.makeText(Insert.this,"LawName and" +
                            " subcategory are neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(category.isEmpty()){
                    Toast.makeText(Insert.this,"LawName are neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(scat.isEmpty()){
                    Toast.makeText(Insert.this,"subcategory are neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(lawname1.isEmpty()){
                    Toast.makeText(Insert.this,"LawName are neccessary!",Toast.LENGTH_LONG).show();
                }
                else {
                    insertdb(category,scat,lawNum0, lawname1, subject2, description3, condition4, panelty5, date6);
                    Toast.makeText(getApplicationContext(), "Data Inserted Succesfully",
                            Toast.LENGTH_SHORT).show();
                    Intent activity = new Intent(Insert.this, Insertref.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Insert.this.startActivity(activity);
                   // finish();
                }
            }
        });

    }

    public void insertdb(String category, String scat,String lawNum0,String lawname1, String subject2, String description3,
                         String condition4, String panelty5, String date6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Key_Category,category);
        contentValues.put(key_Sub_Category, scat);
        contentValues.put(Key_Law_Number,lawNum0);
        contentValues.put(LAW_Name, lawname1);
        contentValues.put(KEY_Subject, subject2);
        contentValues.put(Key_Description, description3);
        contentValues.put(Key_Condition, condition4);
        contentValues.put(Key_Panelty, panelty5);
        contentValues.put(Key_Date, date6);

        db.insert(database.LAW_TABLE_NAME, KEY_ID, contentValues);


    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(Insert.this, AdminProfile.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}


