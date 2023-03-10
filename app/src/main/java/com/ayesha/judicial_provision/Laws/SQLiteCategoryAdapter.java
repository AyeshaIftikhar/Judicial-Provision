package com.ayesha.judicial_provision.Laws;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ayesha.judicial_provision.R;

import java.util.ArrayList;
import java.util.Locale;

class SQLiteCategoryAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> UserName;


    public SQLiteCategoryAdapter(Context context, ArrayList<String> name_arrayList) {
        this.context = context;
        this.UserName = name_arrayList;
    }

    @Override
    public int getCount() {
        return UserName.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Holder holder;
        LayoutInflater inflater;
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_category, null);
            holder = new Holder();
            holder.name = (TextView) view.findViewById(R.id.txtHeading);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        holder.name.setText(UserName.get(position));

        return view;
    }


    public class Holder {
        TextView name;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        Lawsportal.NAME_ArrayList.clear();
        if (charText.length() == 0) {
            Lawsportal.NAME_ArrayList.addAll(UserName);
        } else {
            for (String mp : UserName) {
                if (mp.toLowerCase(Locale.getDefault()).contains(charText)) {
                    Lawsportal.NAME_ArrayList.add(mp);
                }
            }
            notifyDataSetChanged();

        }
    }
}