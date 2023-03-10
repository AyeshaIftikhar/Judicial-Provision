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

import com.ayesha.judicial_provision.database;
import com.ayesha.judicial_provision.R;


public class AddLawCategory extends AppCompatActivity {
    Button ok;
    EditText edt;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_law_category);
        edt = (EditText) findViewById(R.id.edtCat);
        ok = (Button) findViewById(R.id.btnOk);
        final database lawhelper = new database(this);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edt.getText().toString();
                db = lawhelper.getWritableDatabase();
                if(name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Cannot leave field Empty",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    insertcat(name);
                    Toast.makeText(AddLawCategory.this, "database Added Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddLawCategory.this, AddSubCategory.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    AddLawCategory.this.startActivity(intent);
                    //finish();
                }
            }
        });
    }

    public void insertcat(String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.Key_Category_Name, name);
        db.insert(database.Category_TABLE_NAME, null, contentValues);
    }
    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(AddLawCategory.this, AdminProfile.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}