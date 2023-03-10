package com.ayesha.judicial_provision.Laws;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.ayesha.judicial_provision.Cyber_Laws.Access_Info;
import com.ayesha.judicial_provision.Cyber_Laws.CyberLawsStalking;
import com.ayesha.judicial_provision.Cyber_Laws.Spamming;
import com.ayesha.judicial_provision.Cyber_Laws.hacking;
import com.ayesha.judicial_provision.Cyber_Laws.speech;
import com.ayesha.judicial_provision.database;
import com.ayesha.judicial_provision.R;

import java.util.ArrayList;

public class CyberLawsCategories extends Activity implements SearchView.OnQueryTextListener{

    SQLiteDatabase sqLiteDatabase;
    private database cc;
    Cursor cursor;
    SQLiteSubCategoryAdapter listAdapter;
    private ListView lv;
    static ArrayList<String> Name_List = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category);


        cc=new database(this);

        lv=(ListView)findViewById(R.id.sub_cat_list);

        SearchView search=(SearchView)findViewById(R.id.searchSubCat);
        search.setOnQueryTextListener(this);

            showData();


    }

    @Override
    protected void onResume() {
       // showData() ;
        super.onResume();
    }

    private void showData() {
        sqLiteDatabase =cc.getWritableDatabase();
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM SubCategoryTable " +
                "where" +" Category_name=?",new String []{"Cyber"});

        Name_List.clear();

        if (cursor.moveToFirst()) {
            do{
                Name_List.add(cursor.getString(cursor.getColumnIndex(cc.SUB_CATEGORY_Name)));
            }
            while (cursor.moveToNext());
        }

        listAdapter = new SQLiteSubCategoryAdapter(CyberLawsCategories.this, Name_List);
        lv.setAdapter(listAdapter);
        cursor.close();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(CyberLawsCategories.this,
                        Name_List.get(position).trim(), Toast.LENGTH_LONG).show();

               switch (Name_List.get(position)) {
                   case "Access to information": {

                       Intent intent = new Intent(CyberLawsCategories.this, Access_Info.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(intent);
                       break;
                   }
                   case "Hacking": {

                       Intent intent = new Intent(CyberLawsCategories.this, hacking.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(intent);
                       break;
                   }
                    case "Stalking": {

                    Intent intent = new Intent(CyberLawsCategories.this, CyberLawsStalking.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                    }
                    case "Spamming": {

                       Intent intent = new Intent(CyberLawsCategories.this, Spamming.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(intent);
                       break;
                   }
                   case "Speech": {

                       Intent intent = new Intent(CyberLawsCategories.this, speech.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(intent);
                       break;
                   }



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
        Intent intent=new Intent(CyberLawsCategories.this,Lawsportal.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}

