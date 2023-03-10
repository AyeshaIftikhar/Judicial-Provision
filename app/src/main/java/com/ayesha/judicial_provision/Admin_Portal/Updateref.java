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


public class Updateref extends AppCompatActivity {
    private SQLiteDatabase db;
    EditText booketup,chapteretup,pageetup,authornameetup,idetup;
    Button updatebtn;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_references);

        idetup = (EditText) findViewById(R.id.referenceidetup);
        booketup = (EditText) findViewById(R.id.booketup);
        chapteretup = (EditText) findViewById(R.id.chapteretup);
        pageetup = (EditText) findViewById(R.id.pageetup);
        authornameetup = (EditText) findViewById(R.id.authornameetup);
        updatebtn = (Button) findViewById(R.id.okbtn1);

        final database lawhelper = new database(this);
        updatebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String bookup = booketup.getText().toString();
                String chapterup = chapteretup.getText().toString();
                String pageup = pageetup.getText().toString();
                String authornameup = authornameetup.getText().toString();
                String id = idetup.getText().toString();
                db = lawhelper.getWritableDatabase();
                if(id.isEmpty() && bookup.isEmpty() && chapterup.isEmpty()
                        && pageup.isEmpty() && authornameup.isEmpty()){
                    Toast.makeText(Updateref.this,"FIll the form Completely",
                            Toast.LENGTH_LONG).show();
                }
                else if(bookup.isEmpty()){
                    Toast.makeText(Updateref.this,"Book name is required!",
                            Toast.LENGTH_LONG).show();
                }
               else {
                    updateData(id, bookup, chapterup, pageup, authornameup);
                    Toast.makeText(getApplicationContext(), "Data Updated Succesfully",
                            Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Updateref.this, AdminProfile.class );
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Updateref.this.startActivity(intent);
                   // finish();
                }
            }

        });
    }
    public void updateData (String id,String bookup,String chapterup,String pageup,String authornameup){
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.book, bookup);
        contentValues.put(database.chapter, chapterup);
        contentValues.put(database.ref_id, id);
        contentValues.put(database.authorname, authornameup);
        contentValues.put(database.page,pageup);

        db.update(database.references_table_name, contentValues, database.KEY_ID + "=?", new String[]{id});
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(Updateref.this, AdminProfile.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
