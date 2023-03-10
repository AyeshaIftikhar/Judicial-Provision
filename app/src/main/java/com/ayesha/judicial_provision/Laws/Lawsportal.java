package com.ayesha.judicial_provision.Laws;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.ayesha.judicial_provision.Front_Page;
import com.ayesha.judicial_provision.database;
import com.ayesha.judicial_provision.R;

import java.util.ArrayList;

public class Lawsportal extends AppCompatActivity implements SearchView.OnQueryTextListener{
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    SQLiteCategoryAdapter ListAdapter;
    database db;
    private ListView lv;
    SearchView search;
    static ArrayList<String> NAME_ArrayList = new ArrayList<String>();
    int count ;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laws_portal);
        db = new database(this);
        SharedPreferences prefers = getSharedPreferences("DbValue", MODE_PRIVATE);
        count = prefers.getInt("count", 0);
        if(count != 1){
            db.insertCategory();
            db.addCivilCategory();
            db.addCivilLaws(getApplicationContext());
            db.addFemaleProtectionActCategories();
            db.addFemaleProtectionLaws(getApplicationContext());
            db.addCybercategory();
            db.addCyberAct(getApplicationContext());
            count++;
            SharedPreferences prefs = getSharedPreferences("DbValue", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("count", count);
            editor.commit();
        }


        lv=(ListView)findViewById(R.id.list1);

        search = (SearchView) findViewById(R.id.search);
        ShowSQLiteDBdata() ;
        search.setOnQueryTextListener(this);
        lv.setTextFilterEnabled(true);
        // setupSearchView();


    }

    @Override
    protected void onResume() {
       // ShowSQLiteDBdata() ;
        super.onResume();
    }

    protected void ShowSQLiteDBdata() {
        SQLITEDATABASE = db.getWritableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM CategoryTable", null);

        NAME_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do{
                NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(db.Key_Category_Name)));
            }
            while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteCategoryAdapter(Lawsportal.this, NAME_ArrayList);
        lv.setAdapter(ListAdapter);
        cursor.close();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Lawsportal.this,
                        NAME_ArrayList.get(position).trim(), Toast.LENGTH_LONG).show();

                switch (NAME_ArrayList.get(position)) {
                    case "Civil Laws": {
                        Intent intent = new Intent(Lawsportal.this, CivilLawsCategories.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        break;
                    }
                    case "Cyber Crimes Act": {
                       Intent intent = new Intent(Lawsportal.this, CyberLawsCategories.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                       // Toast.makeText(getApplicationContext(),"listner is working",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "Female Protection Act": {
                       Intent intent = new Intent(Lawsportal.this, FemaleProtectionCategories.class);
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
        ListAdapter.filter(text);
        return false;
    }

  /*  @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(Lawsportal.this, Front_Page.class);
        startActivity(intent);
        super.onBackPressed();
    }*/


      /*  if (TextUtils.isEmpty(newText)) {
            lv.clearTextFilter();
           // ListAdapter.getFilter().filter("");
        } else {
            lv.setFilterText(newText);
        }
        return true;
    } */
    /*  private void setupSearchView()
    {
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setSubmitButtonEnabled(true);
        search.setQueryHint("Search Here");
    } */
}
