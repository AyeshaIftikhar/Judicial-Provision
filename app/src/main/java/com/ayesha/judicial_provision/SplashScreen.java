package com.ayesha.judicial_provision;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        handler=new Handler();
        handler.postDelayed(new Runnable(){
            public void run(){

                Intent intent=new Intent(getApplicationContext(),Front_Page.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

}
