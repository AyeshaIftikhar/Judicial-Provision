package com.ayesha.judicial_provision.Lawyers_Portal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import com.ayesha.judicial_provision.R;
import com.ayesha.judicial_provision.User_Portal.SessionJudge;
import com.ayesha.judicial_provision.User_Portal.UserPage;

import java.util.ArrayList;
import java.util.List;

public class Lawyerlistview extends Activity implements SearchView.OnQueryTextListener{
    private ListView list;

    private LawyerAdapter adapter;
    private SearchView editSearch;
    public static List<lawyer> lawyerArrayList=new ArrayList<lawyer>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_list);

        LawyerDataSet ds= new LawyerDataSet();
        lawyerArrayList=ds.getData();

        list = (ListView) findViewById(R.id.lawyerList);

        adapter = new LawyerAdapter(lawyerArrayList,Lawyerlistview.this);
        list.setAdapter(adapter);

        editSearch=(SearchView)findViewById(R.id.searchlawyer);
        editSearch.setOnQueryTextListener(this);


       /* list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long ref_id) {
                Toast.makeText(Lawyerlistview.this, lawyerArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }); */
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

    @Override
    public void onBackPressed() {
        //your custom code here
        Intent intent=new Intent(Lawyerlistview.this, UserPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
