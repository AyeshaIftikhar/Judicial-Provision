package com.ayesha.judicial_provision;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ayesha.judicial_provision.Laws.Lawsportal;

public class Front_Page extends AppCompatActivity {
    // creating objects for buttons
    Button laws, login , emailFB,smsFB;
    // overriding function for work implementation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        laws=(Button)findViewById(R.id.laws1);
        login=(Button)findViewById(R.id.login);
        emailFB=(Button)findViewById(R.id.viaEmail);
        smsFB=(Button)findViewById(R.id.viaSms);

       laws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(Front_Page.this, Lawsportal.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Front_Page.this. startActivity(activity);
                //finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(Front_Page.this,Login.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Front_Page.this. startActivity(activity);
               // finish();
            }
        });

       emailFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(Front_Page.this,Email_feedBack.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Front_Page.this. startActivity(activity);
                //finish();
            }
        });

        smsFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(Front_Page.this,Sms_feedBack.class);
                // set the new task and clear flags
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Front_Page.this. startActivity(activity);
                // finish();
            }
        });

    }
    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 5000);
    }
}


