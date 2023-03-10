package com.ayesha.judicial_provision.Admin_Portal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ayesha.judicial_provision.Laws.CivilLawsCategories;
import com.ayesha.judicial_provision.Login;
import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.civil_laws.DishonestInvestigation;


public class AdminProfile extends AppCompatActivity {

    Button insertadbtn,deleteadbtn,updateadbtn,lawCatbtn,subCat,updateRef,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_profile);
        insertadbtn=(Button)findViewById(R.id.insertedbtn);
        deleteadbtn=(Button)findViewById(R.id.deleteadbtn);
        updateadbtn=(Button)findViewById(R.id.updateadbtn);
        lawCatbtn=(Button)findViewById(R.id.lawcat);
        subCat=(Button)findViewById(R.id.lawSubCat);
        logout=(Button)findViewById(R.id.loggout);
        updateRef=(Button)findViewById(R.id.updateRef);

        lawCatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProfile.this, AddLawCategory.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                AdminProfile.this.startActivity(intent);
               // finish();
            }
        });

        subCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProfile.this, AddSubCategory.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                AdminProfile.this.startActivity(intent);
              //  finish();
            }
        });


        deleteadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProfile.this, Delete.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                AdminProfile.this.startActivity(intent);
              //  finish();
            }
        });

        updateadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProfile.this, Update.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                AdminProfile.this.startActivity(intent);
              //  finish();
            }
        });

        insertadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProfile.this, Insert.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                AdminProfile.this.startActivity(intent);
               // finish();
            }
        });

       updateRef.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(AdminProfile.this, Updateref.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
               AdminProfile.this.startActivity(intent);
             //  finish();
           }
       });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProfile.this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                AdminProfile.this.startActivity(intent);
              //  finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
    }

}