package com.ayesha.judicial_provision.User_Portal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ayesha.judicial_provision.Login;
import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.SignUp;
import com.ayesha.judicial_provision.SmsActivity;
import com.ayesha.judicial_provision.email_functionality;

public class SessionJudge extends AppCompatActivity {
    Button email,sms;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session_judge);

        email=(Button) findViewById(R.id.emailButton);
        sms=(Button)findViewById(R.id.smsButton);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(SessionJudge.this, email_functionality.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(activity);

            }
        });

     sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(SessionJudge.this, SmsActivity.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(activity);

            }
        });
    }
    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(SessionJudge.this,UserPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
