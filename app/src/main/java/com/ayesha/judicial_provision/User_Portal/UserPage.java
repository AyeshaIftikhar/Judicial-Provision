package com.ayesha.judicial_provision.User_Portal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ayesha.judicial_provision.Front_Page;

import com.ayesha.judicial_provision.Laws.Lawsportal;
import com.ayesha.judicial_provision.Lawyers_Portal.Lawyerlistview;
import com.ayesha.judicial_provision.Login;
import com.ayesha.judicial_provision.R;


public class UserPage extends AppCompatActivity {
    Button laws,appeal, cases,logout,sessionJudge,lawyers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        laws=(Button)findViewById(R.id.btnLaws);
        appeal=(Button)findViewById(R.id.btnAppeal);
        sessionJudge=(Button)findViewById(R.id.btnSessionJudge);
        cases=(Button)findViewById(R.id.btnCase);
        lawyers=(Button)findViewById(R.id.btnLawyer);
        logout=(Button)findViewById(R.id.btnLogout);

       laws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(UserPage.this, Lawsportal.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                UserPage.this. startActivity(activity);
               // finish();
            }
        });

        appeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(UserPage.this, Appeal.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                UserPage.this. startActivity(activity);
                finish();
            }
        });

        cases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(UserPage.this, Cases.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                UserPage.this. startActivity(activity);
                finish();
            }
        });

        sessionJudge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity;
                activity = new Intent(UserPage.this, SessionJudge.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                UserPage.this. startActivity(activity);
                finish();
            }
        });

        lawyers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity = new Intent(UserPage.this, Lawyerlistview.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                UserPage.this.startActivity(activity);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(UserPage.this, Login.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                UserPage.this. startActivity(activity);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() { }

}
