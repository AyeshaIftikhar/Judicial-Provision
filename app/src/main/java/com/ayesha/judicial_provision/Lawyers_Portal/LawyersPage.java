package com.ayesha.judicial_provision.Lawyers_Portal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ayesha.judicial_provision.Front_Page;
import com.ayesha.judicial_provision.Login;
import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.User_Portal.UserPage;
import com.ayesha.judicial_provision.email_functionality;


public class LawyersPage extends AppCompatActivity {
    Button addClient, addHearingDate, addTerminationDate, loggedout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_profile);
        addClient=(Button)findViewById(R.id.addclient);
        addHearingDate=(Button)findViewById(R.id.addHearingDate);
        addTerminationDate=(Button)findViewById(R.id.terminationDate);
        loggedout=(Button)findViewById(R.id.logOut);

        addClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity = new Intent(LawyersPage.this, AddClient.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                LawyersPage.this.startActivity(activity);
               // finish();
            }
        });

        addHearingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent hear = new Intent(LawyersPage.this, HearingDate.class);
                hear.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                LawyersPage.this.startActivity(hear);
              //  finish();
            }
        });

        addTerminationDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(LawyersPage.this, TerminationDate.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                LawyersPage.this. startActivity(activity);
              //  finish();
            }
        });
        loggedout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(LawyersPage.this, Login.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                LawyersPage.this. startActivity(activity);
               // finish();
            }
        });
    }

    @Override
    public void onBackPressed() { }
}
