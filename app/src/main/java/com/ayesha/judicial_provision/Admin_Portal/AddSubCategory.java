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


public class AddSubCategory extends AppCompatActivity {
    Button ok;
    EditText edt;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_sub_category);
        edt=(EditText)findViewById(R.id.edtSubCat);
        ok=(Button)findViewById(R.id.btnOK1);
        final database lawhelper = new database(this);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edt.getText().toString();
                db = lawhelper.getWritableDatabase();
                if(name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Cannot leave field Empty",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    insertsubcat(name);
                    Toast.makeText(AddSubCategory.this, "database Added Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddSubCategory.this, Insert.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    AddSubCategory.this.startActivity(intent);
                  //  finish();
                }
            }
        });
    }
    public void insertsubcat(String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.SUB_CATEGORY_Name, name);
        db.insert(database.SUB_CATEGORY_TABLE, null, contentValues);
    }
    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(AddSubCategory.this,AdminProfile.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
