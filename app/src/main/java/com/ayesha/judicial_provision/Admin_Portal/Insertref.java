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


public class Insertref extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_references);

        final EditText booketin = (EditText) findViewById(R.id.bookin);
        final EditText chapteretin= (EditText) findViewById(R.id.chapterin);
        final EditText pageetin = (EditText) findViewById(R.id.pagein);
        final EditText authornameetin = (EditText) findViewById(R.id.authornamein);
        final Button updatebtn = (Button) findViewById(R.id.okbtn1in);

        final database lawhelper = new database(this);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            private SQLiteDatabase db;

            @Override
            public void onClick(View v) {
                String bookin= booketin.getText().toString();
                String chapterin = chapteretin.getText().toString();
                String pagein = pageetin.getText().toString();
                String authornamein = authornameetin.getText().toString();

                db = lawhelper.getWritableDatabase();
                if(bookin.isEmpty() && chapterin.isEmpty() && pagein.isEmpty() && authornamein.isEmpty()){
                    Toast.makeText(Insertref.this,"Add details completely",Toast.LENGTH_LONG).show();
                }
                else if(bookin.isEmpty()){
                    Toast.makeText(Insertref.this,"Name of book is required!",Toast.LENGTH_LONG).show();
                }
                else {
                    updateData(bookin, chapterin, pagein, authornamein);
                    Toast.makeText(getApplicationContext(), "Data Inserted Succesfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Insertref.this,AdminProfile.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Insertref.this.startActivity(intent);
                   // finish();
                }
            }
            public void updateData (String bookin,String chapterin,String pagein,String authornamein){
                ContentValues contentValues = new ContentValues();
                contentValues.put(database.book, bookin);
                contentValues.put(database.chapter, chapterin);
                contentValues.put(database.authorname, authornamein);
                contentValues.put(database.page,pagein);
                db.insert(database.references_table_name, null, contentValues);
            }


        });
    }
    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(Insertref.this, Insert.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
