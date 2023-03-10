package com.ayesha.judicial_provision.User_Portal;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.database;

import org.w3c.dom.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Appeal extends AppCompatActivity {
    EditText appealTo, appealFrom, caseNo, subject, description;
    Button submit,report;
    private SQLiteDatabase db;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appealform);

        //////permisiion///

        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            Log.v("permission tag","Permission is granted");
            //File write logic here

        }
        else
        {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        //ends hewre///////////////




        appealTo = (EditText) findViewById(R.id.appealTO);
        appealFrom = (EditText) findViewById(R.id.appealFrom);
        caseNo = (EditText) findViewById(R.id.caseNo);
        subject = (EditText) findViewById(R.id.subject);
        description = (EditText) findViewById(R.id.desc);
        submit = (Button) findViewById(R.id.submit);
        report = (Button) findViewById(R.id.report);

        final database lawhelper = new database(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apT = appealTo.getText().toString();
                String apF = appealFrom.getText().toString();
                String cn = caseNo.getText().toString();
                String sb = subject.getText().toString();
                String des = description.getText().toString();
                db = lawhelper.getWritableDatabase();

                if(apT.isEmpty() && apF.isEmpty() && cn.isEmpty() && sb.isEmpty() && des.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill form completely!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && apF.isEmpty() && cn.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && apF.isEmpty() && cn.isEmpty() && des.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && apF.isEmpty() && des.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && des.isEmpty() && cn.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(des.isEmpty() && apF.isEmpty() && cn.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && apF.isEmpty() && cn.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && apF.isEmpty() &&  sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && apF.isEmpty() && des.isEmpty() ){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && cn.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() &&  cn.isEmpty() && des.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && des.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if( apF.isEmpty() && cn.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if( apF.isEmpty() && cn.isEmpty() && des.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if( des.isEmpty() && cn.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Please Fill the empty fields first!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && apF.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Appeal to and Appeal from is required!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && cn.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Appeal to and case number is required!!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Appeal to and subject is required!!",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty() && des.isEmpty() ){
                    Toast.makeText(Appeal.this,
                            "Appeal to and description is required!!",Toast.LENGTH_LONG).show();
                }
                else if( apF.isEmpty() && cn.isEmpty() ){
                    Toast.makeText(Appeal.this,
                            "Appeal from and case number is required!!",Toast.LENGTH_LONG).show();
                }
                else if(apF.isEmpty()  && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Appeal from and subject is required!!",Toast.LENGTH_LONG).show();
                }
                else if( apF.isEmpty() && des.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Appeal from and description is required!!",Toast.LENGTH_LONG).show();
                }
                else if(cn.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "case number and subject is required!",Toast.LENGTH_LONG).show();
                }
                else if( cn.isEmpty() && des.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "case number and discription is required!",Toast.LENGTH_LONG).show();
                }
                else if( des.isEmpty() && sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "subject and description is required",Toast.LENGTH_LONG).show();
                }
                else if(apT.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Appeal To is required!",Toast.LENGTH_LONG).show();
                }
                else if(apF.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "Appeal from is required!",Toast.LENGTH_LONG).show();
                }
                else if( cn.isEmpty() ){
                    Toast.makeText(Appeal.this,
                            "case number is required!",Toast.LENGTH_LONG).show();
                }
                else if(sb.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "subject is required!",Toast.LENGTH_LONG).show();
                }
                else if(des.isEmpty()){
                    Toast.makeText(Appeal.this,
                            "description is required!",Toast.LENGTH_LONG).show();
                }
                else{
                    insertappeal(apT, apF, cn, sb, des);
                    Intent activity = new Intent(Appeal.this, UserPage.class);
                    activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Appeal.this.startActivity(activity);
                    finish();
                }


            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPdf(appealTo.getText().toString(),
                        appealFrom.getText().toString(),caseNo.getText().toString(),
                        subject.getText().toString(),description.getText().toString());
            }
        });



    }

    public void insertappeal(String apT, String apF, String cn, String sb, String des) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(database.appealto, apT);
        contentValues.put(database.appealfrom, apF);
        contentValues.put(database.caseno, cn);
        contentValues.put(database.subject, sb);
        contentValues.put(database.descriptionappeal, des);

        long id = db.insert(database. appeal_table_name,
                null, contentValues);

    }



    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void createPdf(String apt,String apf,String cno,String sbj,String desc){
        // create a new document
        PdfDocument document = new PdfDocument();
        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo
                .Builder(300, 600, 1).create();
        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(7);
        canvas.drawText("Appeal Report -Judicial Provision- ",10,10,paint);

        paint.setTextSize(20);
        canvas.drawText("Appeal To: ",10,120,paint);
        canvas.drawText(apt, 130, 140, paint);
        canvas.drawText("Appeal From: ",10,200,paint);
        canvas.drawText(apf, 130, 220, paint);
        canvas.drawText("Case no: ",10,280,paint);
        canvas.drawText(cno, 130, 300, paint);
        canvas.drawText("Subject: ",10,360,paint);
        canvas.drawText(sbj, 130, 380, paint);
        canvas.drawText("Description: ",10,440,paint);
        canvas.drawText(desc, 130, 460, paint);
        paint.setTextSize(7);
        canvas.drawText("Page 1 of 1",130,590,paint);
        //canvas.drawt
        // finish the page
        document.finishPage(page);
// draw text on the graphics object of the page

        // write the document content
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/mypdf/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String targetPdf = directory_path+"Appeal Report.pdf";
        File filePath = new File(targetPdf);
        try {
            document.writeTo(new FileOutputStream(filePath));
            Toast.makeText(this, "PDF Generatd!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("main", "error "+e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(),  Toast.LENGTH_LONG).show();
        }
        // close the document
        document.close();
    }
    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(Appeal.this,UserPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}