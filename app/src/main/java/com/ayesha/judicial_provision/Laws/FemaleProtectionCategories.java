package com.ayesha.judicial_provision.Laws;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.ayesha.judicial_provision.database;
import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.female_protection.criminalForce;
import com.ayesha.judicial_provision.female_protection.false_info;
import com.ayesha.judicial_provision.female_protection.inducing;
import com.ayesha.judicial_provision.female_protection.prostitution;

import java.util.ArrayList;

public class FemaleProtectionCategories extends Activity implements SearchView.OnQueryTextListener {


    SQLiteDatabase sqLiteDatabase;
    private database sc;
    Cursor cursor;
    SQLiteSubCategoryAdapter listAdapter;
    private ListView lv;
    static ArrayList<String> Name_List = new ArrayList<String>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category);


        sc=new database(this);


        lv=(ListView)findViewById(R.id.sub_cat_list);

       SearchView search=(SearchView)findViewById(R.id.searchSubCat);
       search.setOnQueryTextListener(this);

        showData();

    }

    @Override
    protected void onResume() {
        //showData() ;
        super.onResume();
    }

    private void showData() {
        sqLiteDatabase =sc.getWritableDatabase();
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM SubCategoryTable " +
                "where" +" Category_name=?",new String []{"FemaleProtectAct"});

        Name_List.clear();

        if (cursor.moveToFirst()) {
            do{
                Name_List.add(cursor.getString(cursor.getColumnIndex(sc.SUB_CATEGORY_Name)));
            }
            while (cursor.moveToNext());
        }

        listAdapter = new SQLiteSubCategoryAdapter(FemaleProtectionCategories.this, Name_List);
        lv.setAdapter(listAdapter);
        cursor.close();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FemaleProtectionCategories.this,
                        Name_List.get(position).trim(), Toast.LENGTH_LONG).show();

              switch (Name_List.get(position)){
                  case "False_Information":
                      Intent intent=new Intent(FemaleProtectionCategories.this, false_info.class);
                      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                      startActivity(intent);
                      break;
                  case "Using criminal force":
                      Intent intent1=new Intent(FemaleProtectionCategories.this, criminalForce.class);
                      intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                      startActivity(intent1);
                      break;
                  case "Inducing":
                      Intent intent2=new Intent(FemaleProtectionCategories.this, inducing.class);
                      intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                      startActivity(intent2);
                      break;
                  case "Prostititution":
                      Intent intent3=new Intent(FemaleProtectionCategories.this, prostitution.class);
                      intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                      startActivity(intent3);
                      break;
              }
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        listAdapter.filterText(text);
        return false;
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(FemaleProtectionCategories.this,Lawsportal.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
