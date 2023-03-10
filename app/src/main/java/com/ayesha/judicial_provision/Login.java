package com.ayesha.judicial_provision;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ayesha.judicial_provision.Admin_Portal.AdminProfile;
import com.ayesha.judicial_provision.Lawyers_Portal.LawyersPage;
import com.ayesha.judicial_provision.User_Portal.UserPage;


import java.sql.SQLException;


public class Login extends AppCompatActivity{
    EditText userName, password;
    Button logIn, signUp;
    database db , db1;
    Cursor cursor,cursor2;
    SQLiteDatabase sqLiteDatabase;
    String uName,uPassword,lawyerName,lawyerPass;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        userName=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        logIn=(Button)findViewById(R.id.login1);
        signUp=(Button)findViewById(R.id.regN);
        db = new database(this);
        db1=new database(this);
        //getUserData();
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=userName.getText().toString();
                String pass=password.getText().toString();
                try {
                    if(LoginUser(name,pass)) {
                        Toast.makeText(Login.this,
                                "Login Successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Login.this, UserPage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        Login.this.startActivity(intent);
                    }
                    else if(LoginLawyer(name,pass)){
                        Toast.makeText(Login.this,
                                "Login Successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Login.this, LawyersPage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        Login.this.startActivity(intent);
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }

                if(name.equals("admin") && pass.equals("1234")) {
                    Toast.makeText(Login.this,
                            "Login Successful",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, AdminProfile.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Login.this.startActivity(intent);
                  //  finish();

                }
                else if(name.equals("ayesha") && pass.equals("2324") ){
                    Toast.makeText(Login.this,
                            "Login Successful",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, UserPage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Login.this.startActivity(intent);
                   // finish();
                }

                else if(name.equals("faraz") && pass.equals("23256")){
                    Toast.makeText(Login.this,
                            "Login Successful",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, LawyersPage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Login.this.startActivity(intent);
                   // finish();
                }
                else if(name.isEmpty() && pass.isEmpty()){
                    Toast.makeText(Login.this,
                            "USERNAME AND PASSWORD ARE REQUIRED",Toast.LENGTH_LONG).show();
                }
                else if(name.isEmpty()){
                    Toast.makeText(Login.this,
                            "Please Enter the Username!",Toast.LENGTH_LONG).show();
                }
                else if(pass.isEmpty()){
                    Toast.makeText(Login.this,
                            "Please Enter the Password!",Toast.LENGTH_LONG).show();
                }

                else if(!name.equals("ayesha") && !name.equals("admin") && !name.equals("faraz")
                 && !name.equals(db.username) && !name.equals(db. lawyername)){
                    Toast.makeText(Login.this,
                            "Invalid UserName! \n Please ReEnter the UserName",Toast.LENGTH_LONG).show();

                }
                else if(!pass.equals("1234") && !pass.equals("2324") && !pass.equals("23256") &&
                !pass.equals(db.Lawyer_password ) && !pass.equals(db.user_password)){
                    Toast.makeText(Login.this,
                            "Wrong Password! \n TRY AGAIN!",Toast.LENGTH_LONG).show();

                }

                 /*  else if(name.equals(db.username) && pass.equals(db.user_password)){
                    Toast.makeText(Login.this,
                            "Login Successful",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, UserPage.class);
                    Login.this.startActivity(intent);
                }
                else if(name.equals(db1.lawyername) && pass.equals(db1.Lawyer_password)){
                    Toast.makeText(Login.this,
                            "Login Successful",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, LawyersPage.class);
                    Login.this.startActivity(intent);
                }*/
                else{
                    Toast.makeText(Login.this,
                            "You are not an registered user signup first!",Toast.LENGTH_LONG).show();
                }
                cursor.close();
                cursor2.close();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(Login.this,SignUp.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Login.this. startActivity(activity);

            }
        });

       /* TextView forgetPass=(TextView)findViewById(R.ref_id.txtForgetPassword);
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity=new Intent(Login.this, ForgetPassword.class);
                Login.this. startActivity(activity);

            }
        });*/

    }

    public boolean LoginUser(String username, String password) throws SQLException {
        sqLiteDatabase = sqLiteDatabase = db.getWritableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT User_Name, user_Password FROM Users_Table" +
                " where "+"User_Name=?  AND "+"user_Password=?",new String []{username,password});
        if (cursor != null) {
            if(cursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    public boolean LoginLawyer(String username, String password) throws SQLException {
        sqLiteDatabase = db.getWritableDatabase();
        cursor2 = sqLiteDatabase.rawQuery("Select Lawyer_Name, lawyer_Password From Lawyers_table" +
                " where "+"Lawyer_Name=?  AND "+"Lawyer_Name=?",new String []{username,password});
        if (cursor2 != null) {
            if(cursor2.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent = new Intent(Login.this, Front_Page.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
   /* private void getUserData() {
        String query1="Select User_Name, user_Password From Users_table";
        sqLiteDatabase = db.getWritableDatabase();
        cursor=sqLiteDatabase.rawQuery(query1,null);
        if(cursor.moveToNext()){
           do{
                NumberList.add(cursor.getString(cursor.getColumnIndex(db.Key_Law_Number)));
                NameList.add(cursor.getString(cursor.getColumnIndex(db.LAW_Name)));
            }
            while (cursor.moveToNext());
        } */
    }

//}
