package com.ayesha.judicial_provision.User_Portal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayesha.judicial_provision.Login;
import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.SignUp;
import com.ayesha.judicial_provision.database;


public class UserSignUp extends AppCompatActivity {
    EditText name, email, password, phoneNo,Address;
    Button ok;
    private SQLiteDatabase db;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_sign_up);
        name=(EditText)findViewById(R.id.EdtxtName);
        password=(EditText)findViewById(R.id.edTxtPw);
        email=(EditText)findViewById(R.id.edTxtemail1) ;
        phoneNo=(EditText)findViewById(R.id.edTxtphone);
        Address=(EditText)findViewById(R.id.edTxtaddr);
        ok=(Button)findViewById(R.id.signup2);

        final database lawhelper = new database(this);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=name.getText().toString();
                String pass=password.getText().toString();
                String addr=Address.getText().toString();
                String ph=phoneNo.getText().toString();
                String em=email.getText().toString();

                db = lawhelper.getWritableDatabase();

                if(n.isEmpty() && pass.isEmpty() && addr.isEmpty() && ph.isEmpty() && em.isEmpty()){
                    Toast.makeText(UserSignUp.this ,
                            "Please Fil the complete form first!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && pass.isEmpty() && ph.isEmpty() && em.isEmpty()){
                    Toast.makeText(UserSignUp.this ,
                            "Name,Password,Email and PhoneNUmber are Required!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && ph.isEmpty() && em.isEmpty()){
                    Toast.makeText(UserSignUp.this ,
                            "Attributes like Name,PhoneNumber and Email are Required!!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && pass.isEmpty() && em.isEmpty()){
                    Toast.makeText(UserSignUp.this ,
                            "Attributes like Name,Password and Email are Required!!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && ph.isEmpty() && pass.isEmpty()){
                    Toast.makeText(UserSignUp.this ,
                            "Attributes like Name,PhoneNumber and password are Required!!",Toast.LENGTH_LONG).show();
                }
                else if( pass.isEmpty()  && ph.isEmpty() && em.isEmpty()){
                    Toast.makeText(UserSignUp.this ,
                            "Attributes like Password,PhoneNumber " +
                                    "and Email are Required!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "UserName and Password Should not NULL!",Toast.LENGTH_LONG).show();
                }

                else if(n.isEmpty() && ph.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "UserName and Phone must not Empty!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && em.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "UserName and Password Should not left blank!",Toast.LENGTH_LONG).show();
                }
                else if(pass.isEmpty() && ph.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "PhoneNumber and Password are Neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(pass.isEmpty() && em.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "Password and Email are Neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(ph.isEmpty() && em.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "PhoneNumber and Email are Neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "Please Enter the Name!",Toast.LENGTH_LONG).show();
                }
                else if(pass.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "Please enter thr password for your security!",Toast.LENGTH_LONG).show();
                }
                else if(ph.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "Please enter the PhoneNumber!",Toast.LENGTH_LONG).show();
                }
                else if( em.isEmpty()) {
                    Toast.makeText(UserSignUp.this ,
                            "Please enter the Email!",Toast.LENGTH_LONG).show();
                }
                else {
                    insertuser(n, pass, addr, ph, em);
                    Intent activity = new Intent(UserSignUp.this, Login.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    UserSignUp.this.startActivity(activity);
                   // finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(UserSignUp.this, SignUp.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
    public void insertuser(String n, String pass, String addr, String ph, String em) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.username,n);
        contentValues.put(database.address, addr);
        contentValues.put(database.phone,ph);
        contentValues.put(database.email,em);
        contentValues.put(database.Lawyer_password, pass);
      //  contentValues.put(Users.dateofcreation,)
        long id = db.insert(database.user_table_name , null, contentValues);


    }
}
