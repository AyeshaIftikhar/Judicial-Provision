package com.ayesha.judicial_provision.Cyber_Laws;

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

import com.ayesha.judicial_provision.Laws.CyberLawsCategories;
import com.ayesha.judicial_provision.Laws.SqLiteLawsAdapter;
import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.database;
import com.ayesha.judicial_provision.female_protection.criminalForce;
import com.ayesha.judicial_provision.female_protection.criminalForce_frag;

import java.util.ArrayList;

public class Spamming extends Activity implements SearchView.OnQueryTextListener {

    SQLiteDatabase sqLiteDatabase;
    private database db;
    Cursor cursor;
    SqLiteLawsAdapter listAdapter;

    private ListView lv;
    static ArrayList<String> NameList = new ArrayList<String>();
    static ArrayList<String> NumberList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laws_list);


        db=new database(this);
      //  db.addCyberAct(getApplicationContext());

        lv=(ListView)findViewById(R.id.laws_list);

        SearchView search=(SearchView)findViewById(R.id.searchLaw);
        search.setOnQueryTextListener(this);

        showLaws();

    }

    @Override
    protected void onResume() {
       // showLaws() ;
        super.onResume();
    }

    private void showLaws() {
        sqLiteDatabase =db.getWritableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM Laws_Table" +
                " where "+"Category=?  AND "+"Sub_Category_name=?",new String []{"Cyber","Spamming "});

        NameList.clear();
        NumberList.clear();


        if (cursor.moveToFirst()) {
            do{
                NumberList.add(cursor.getString(cursor.getColumnIndex(db.Key_Law_Number)));
                NameList.add(cursor.getString(cursor.getColumnIndex(db.LAW_Name)));
            }
            while (cursor.moveToNext());
        }

        listAdapter = new SqLiteLawsAdapter(Spamming.this,NumberList, NameList);
        lv.setAdapter(listAdapter);
        cursor.close();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Spamming.this,
                        NameList.get(position).trim(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Spamming.this, spamming_frag.class);
                startActivity(intent);

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
        Intent intent=new Intent(Spamming.this, CyberLawsCategories.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}

