package com.ayesha.judicial_provision.Lawyers_Portal;

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


public class lawyerSignUp extends AppCompatActivity {
    EditText name, email, password, phoneNo,Address , lawyerNo;
    Button ok;
    private SQLiteDatabase db;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_signup);

        name=(EditText)findViewById(R.id.EdtxtName);
        password=(EditText)findViewById(R.id.edTxtPass);
        email=(EditText)findViewById(R.id.edTxtEmail) ;
        phoneNo=(EditText)findViewById(R.id.edTxtphone);
        Address=(EditText)findViewById(R.id.edTxtadd);
        lawyerNo=(EditText)findViewById(R.id.EtxtLNo);
        ok=(Button)findViewById(R.id.signup1);

        final database lawhelper = new database(this);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=name.getText().toString();
                String pass=password.getText().toString();
                String addr=Address.getText().toString();
                String ph=phoneNo.getText().toString();
                String ln=lawyerNo.getText().toString();
                String em=email.getText().toString();

                db = lawhelper.getWritableDatabase();
                if(n.isEmpty() && pass.isEmpty() && addr.isEmpty()
                        && ph.isEmpty() && ln.isEmpty() &&em.isEmpty()){
                    Toast.makeText(lawyerSignUp.this,
                            "All fields should be filled completely",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && pass.isEmpty() && ph.isEmpty() && em.isEmpty() && ln.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Name,Password,Email, lawyerNumber and PhoneNUmber are Required!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && pass.isEmpty() && ph.isEmpty() && em.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Name,Password,Email and PhoneNUmber are Required!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && pass.isEmpty() && ph.isEmpty() &&  ln.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Name,Password, lawyerNumber and PhoneNUmber are Required!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && pass.isEmpty() &&  em.isEmpty() && ln.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Name,Password,Email, lawyerNumber are Required!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty()  && ph.isEmpty() && em.isEmpty() && ln.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Name,Email, lawyerNumber and PhoneNUmber are Required!",Toast.LENGTH_LONG).show();
                }
                else if( pass.isEmpty() && ph.isEmpty() && em.isEmpty() && ln.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Password,Email, lawyerNumber and PhoneNUmber are Required!",Toast.LENGTH_LONG).show();
                }

                else if(n.isEmpty() && ph.isEmpty() && em.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Attributes like Name,PhoneNumber and Email are Required!!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && ph.isEmpty() && pass.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Attributes like Name,PhoneNumber and password are Required!!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && ph.isEmpty() && ln.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Attributes like Name,PhoneNumber and lawyerNumber are Required!!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && pass.isEmpty() && em.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Attributes like Name,Password and Email are Required!!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && ln.isEmpty() && pass.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Attributes like Name,lawyerNumber and password are Required!!",Toast.LENGTH_LONG).show();
                }
                else if( pass.isEmpty()  && ph.isEmpty() && em.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Attributes like Password,PhoneNumber " +
                                    "and Email are Required!",Toast.LENGTH_LONG).show();
                }
                else if(ln.isEmpty() && ph.isEmpty() && pass.isEmpty()){
                    Toast.makeText(lawyerSignUp.this ,
                            "Attributes like lawyerNumber,PhoneNumber and password are Required!!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "UserName and Password Should not NULL!",Toast.LENGTH_LONG).show();
                }

                else if(n.isEmpty() && ph.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "UserName and Phone must not Empty!",Toast.LENGTH_LONG).show();
                }

                else if(n.isEmpty() && ln.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this,
                            "UserName and lawyerNumbr Should not left blank!", Toast.LENGTH_LONG).show();
                }
                else if(pass.isEmpty() && ph.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "PhoneNumber and Password are Neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(pass.isEmpty() && em.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "Password and Email are Neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(ph.isEmpty() && em.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "PhoneNumber and Email are Neccessary!",Toast.LENGTH_LONG).show();
                }
                else if(ph.isEmpty() && ln.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "phone number and lawyerNumber Should not left blank!",Toast.LENGTH_LONG).show();
                }
                else if(ln.isEmpty() && em.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "lawyerNummber and Email Should not left blank!",Toast.LENGTH_LONG).show();
                }
                else if(n.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "Please Enter the Name!",Toast.LENGTH_LONG).show();
                }
                else if(pass.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "Please enter thr password for your security!",Toast.LENGTH_LONG).show();
                }
                else if(ph.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "Please enter the PhoneNumber!",Toast.LENGTH_LONG).show();
                }
                else if( em.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "Please enter the Email!",Toast.LENGTH_LONG).show();
                }
                else if( ln.isEmpty()) {
                    Toast.makeText(lawyerSignUp.this ,
                            "Please enter the lawynerNumber!",Toast.LENGTH_LONG).show();
                }
                else {
                    lawyersignu(n, pass, addr, ph, ln, em);
                    Intent activity = new Intent(lawyerSignUp.this, Login.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    lawyerSignUp.this.startActivity(activity);
                   // finish();
                }
            }
        });
    }

    public void lawyersignu(String n, String pass, String addr, String ph,String ln,String em) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.lawyername, n);
        contentValues.put(database.Lawyer_password, pass);
        contentValues.put(database.address, addr);
        contentValues.put(database.phone, ph);
        db.insert(database.lawyers_table_name, null, contentValues);
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(lawyerSignUp.this, SignUp.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
