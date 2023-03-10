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


public class AddReference extends AppCompatActivity {
    private SQLiteDatabase db;
    EditText booketup, chaptereupt, pageetup , authornameetup,idrefetup;
    Button ok;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_references);
        idrefetup=(EditText) findViewById(R.id.referenceidetup);
        booketup = (EditText) findViewById(R.id.booketup);
        chaptereupt = (EditText) findViewById(R.id.chapteretup);
        pageetup = (EditText) findViewById(R.id.pageetup);
        authornameetup = (EditText) findViewById(R.id.authornameetup);
        ok=(Button)findViewById(R.id.okbtn1);

        final database lawRef = new database(this);
        ok.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String id=idrefetup.getText().toString();
                String book7up = booketup.getText().toString();
                String chapter8up = chaptereupt.getText().toString();
                String page9up = pageetup.getText().toString();
                String authorname10up = authornameetup.getText().toString();
                db = lawRef.getWritableDatabase();
                if(book7up.isEmpty() && chapter8up.isEmpty() && page9up.isEmpty() && authorname10up.isEmpty()){
                    Toast.makeText(getApplicationContext(),
                            "Cannot leave field Empty", Toast.LENGTH_LONG).show();
                }
                else if(book7up.isEmpty()){
                    Toast.makeText(AddReference.this,"Name of book is required!",Toast.LENGTH_LONG).show();
                }
                else {
                    updateData(id,book7up, chapter8up, page9up, authorname10up);
                    Toast.makeText(getApplicationContext(),
                            "Data Updated Succesfully", Toast.LENGTH_SHORT).show();

                    Intent activity = new Intent(AddReference.this, AdminProfile.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    AddReference.this.startActivity(activity);
                   // finish();
                }
            }


        });
    }
    public void updateData ( String id,String book7up, String chapter8up, String page9up, String authorname10up){
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.book, book7up);
        contentValues.put(database.chapter, chapter8up);
        contentValues.put(database.page, page9up);
        contentValues.put(database.authorname, authorname10up);

        db.update(database.references_table_name, contentValues, database.ref_id + "="+id,null);
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(AddReference.this,Update.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}



