package com.ayesha.judicial_provision;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.ayesha.judicial_provision.User_Portal.SessionJudge;
import com.ayesha.judicial_provision.User_Portal.UserPage;

public class email_functionality extends Activity {


    Button buttonSend;

    EditText textSubject;
    EditText textMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_layout);

        buttonSend = (Button) findViewById(R.id.buttonSend);
        textSubject = (EditText) findViewById(R.id.editTextSubject);
        textMessage = (EditText) findViewById(R.id.editTextMessage);

        buttonSend.setOnClickListener(new OnClickListener() {

            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {

                String subject = textSubject.getText().toString();
                String message = textMessage.getText().toString();
                String mailto = "mailto: ayeshaiftikhar822@gmil.com" +
                        "&subject=" + Uri.encode(subject) +
                        "&body=" + Uri.encode(message);

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse(mailto));

                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {
                    //TODO: Handle case where no email app is available
                }

               /*//
                String strEmailAddress="ayeshaiftikhar291@gmail.com";
                Intent email = new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse(strEmailAddress));
               // email.putExtra(Intent.EXTRA_EMAIL, strEmailAddress);
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
               email.setType("message/rfc822");
                    //email.setType("plain/text");
                //startActivity(Intent.createChooser(email, "Choose an Email client :"));
                startActivity(email);*/
            }
        });
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(email_functionality.this,SessionJudge.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
