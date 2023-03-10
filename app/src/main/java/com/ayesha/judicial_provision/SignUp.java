package com.ayesha.judicial_provision;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ayesha.judicial_provision.Lawyers_Portal.lawyerSignUp;
import com.ayesha.judicial_provision.User_Portal.UserSignUp;


public class SignUp extends AppCompatActivity {
    Button lawyerSign, userSign;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        lawyerSign=(Button)findViewById(R.id.lawyer);
        userSign=(Button)findViewById(R.id.users);
        lawyerSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(SignUp.this, lawyerSignUp.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                SignUp.this. startActivity(activity);
              //  finish();
            }
        });
        userSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(SignUp.this, UserSignUp.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                SignUp.this. startActivity(activity);
               // finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(SignUp.this, Front_Page.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
