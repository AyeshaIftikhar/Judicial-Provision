package com.ayesha.judicial_provision.Admin_Portal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.database;

public class Delete extends AppCompatActivity {
    private AdminProfile db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_data);
        final Button deletebtn = (Button) findViewById(R.id.deletebtn);
        final EditText deleteet = (EditText) findViewById(R.id.deleteet);
        final EditText deleteref = (EditText) findViewById(R.id.deleteref);
        final database lawhelper = new database(this);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            private SQLiteDatabase db;

            @Override
            public void onClick(View v) {
                db = lawhelper.getWritableDatabase();
                String lawid = deleteet.getText().toString();
                String refid = deleteref.getText().toString();
                if(lawid.isEmpty() && refid.isEmpty()){
                    Toast.makeText(getApplicationContext(), "No field can be empty",
                            Toast.LENGTH_LONG).show();
                }
                else if(lawid.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter lawid to delete law!",
                            Toast.LENGTH_LONG).show();
                }
                else if(refid.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter reference ref_id for deletion of  law!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    deleteData(lawid);
                    deletedata(refid);
                    Toast.makeText(getApplicationContext(), "Deleted Succesfully", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Delete.this,AdminProfile.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Delete.this.startActivity(intent);
                  ///  finish();
                }
            }
            public void deleteData(String lawid) {
                db.delete(database.LAW_TABLE_NAME, database.KEY_ID+ "=?", new String[]{lawid});

            }
            public void deletedata(String refid) {
                db.delete(database.references_table_name, database.ref_id + "=?", new String[]{refid});

            }
        });
    }
    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(Delete.this, AdminProfile.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
