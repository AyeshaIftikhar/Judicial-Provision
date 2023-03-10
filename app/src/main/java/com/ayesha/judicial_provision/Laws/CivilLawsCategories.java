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

import com.ayesha.judicial_provision.civil_laws.DishonestInvestigation;
import com.ayesha.judicial_provision.civil_laws.forceUsage;
import com.ayesha.judicial_provision.civil_laws.fraudulanent;
import com.ayesha.judicial_provision.civil_laws.offences;
import com.ayesha.judicial_provision.civil_laws.unlawfulLabour;
import com.ayesha.judicial_provision.database;
import com.ayesha.judicial_provision.R;

import java.util.ArrayList;

public class CivilLawsCategories extends Activity implements SearchView.OnQueryTextListener{

    SQLiteDatabase sqLiteDatabase;
    private database sc;
    Cursor cursor;
    SQLiteSubCategoryAdapter listAdapter;
    private ListView lv;
    static ArrayList<String> Name_ArrayList = new ArrayList<String>();

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
       // showData() ;
        super.onResume();
    }

    private void showData() {
        sqLiteDatabase =sc.getWritableDatabase();
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM SubCategoryTable " +
                "where" +" Category_name=?",new String []{"civil"});

        Name_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do{
                Name_ArrayList.add(cursor.getString(cursor.getColumnIndex(sc.SUB_CATEGORY_Name)));
            }
            while (cursor.moveToNext());
        }

        listAdapter = new SQLiteSubCategoryAdapter(CivilLawsCategories.this, Name_ArrayList);
        lv.setAdapter(listAdapter);
        cursor.close();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(CivilLawsCategories.this,
                        Name_ArrayList.get(position), Toast.LENGTH_LONG).show();

                switch (Name_ArrayList.get(position)){
                    case "Usage of criminal force":
                        Intent intent=new Intent(CivilLawsCategories.this,forceUsage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        break;
                    case "Dishonest Investigation":
                        Intent intent1=new Intent(CivilLawsCategories.this,DishonestInvestigation.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent1);
                        break;
                    case "Offences":
                        Intent i=new Intent(CivilLawsCategories.this,offences.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                        break;
                    case "Unlawful Labour":
                        Intent int2=new Intent(CivilLawsCategories.this,unlawfulLabour.class);
                        int2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(int2);
                        break;
                    case "Fraudulent":
                        Intent int3=new Intent(CivilLawsCategories.this,fraudulanent.class);
                        int3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(int3);
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
        Intent intent=new Intent(CivilLawsCategories.this,Lawsportal.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
