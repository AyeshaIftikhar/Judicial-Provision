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

public class AddClient extends AppCompatActivity {
    Button next;
    EditText name, phoneNo, address, email;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_client);
        name = (EditText) findViewById(R.id.clientName);
        email = (EditText) findViewById(R.id.clientEmail);
        phoneNo = (EditText) findViewById(R.id.clientphNo);
        address = (EditText) findViewById(R.id.clientaddress);
        next = (Button) findViewById(R.id.next);

        final database lawhelper = new database(this);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cn = name.getText().toString();
                String cph = phoneNo.getText().toString();
                String cAdd = address.getText().toString();
                String cEmail = email.getText().toString();

                db = lawhelper.getWritableDatabase();
                if(cn.isEmpty() && cph.isEmpty() && cAdd.isEmpty() && cEmail.isEmpty()){
                    Toast.makeText(AddClient.this,
                            "fill the form Completely!",
                            Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty() && cph.isEmpty() && cAdd.isEmpty()){
                    Toast.makeText(AddClient.this,"Name, Phone Number and Address of client is necessary",
                            Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty() && cph.isEmpty()){
                    Toast.makeText(AddClient.this,"Name, Phone Number of client is necessary",
                            Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty() && cAdd.isEmpty()){
                    Toast.makeText(AddClient.this,"Name, Address of client is necessary",
                            Toast.LENGTH_LONG).show();
                }
                else if(cph.isEmpty() && cAdd.isEmpty()){
                    Toast.makeText(AddClient.this," Phone Number and Address of client is necessary",
                            Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty()){
                    Toast.makeText(AddClient.this,"Name of client is necessary",
                            Toast.LENGTH_LONG).show();
                }
                else if(cph.isEmpty()){
                    Toast.makeText(AddClient.this," Phone Number of client is necessary",
                            Toast.LENGTH_LONG).show();
                }
                else if(cAdd.isEmpty()){
                    Toast.makeText(AddClient.this,"Address of client is necessary",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    addclient(cn, cph, cAdd, cEmail);
                    Intent activity = new Intent(AddClient.this, addCase.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    AddClient.this.startActivity(activity);
                  //  finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(AddClient.this, LawyersPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }

    public void addclient(String cn, String cph, String cAdd, String cEmail) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.clientname, cn);
        contentValues.put(database.phone, cph);
        contentValues.put(database.address, cAdd);
        contentValues.put(database.email, cEmail);
        db.insert(database.client_table_name , null, contentValues);
    }
}