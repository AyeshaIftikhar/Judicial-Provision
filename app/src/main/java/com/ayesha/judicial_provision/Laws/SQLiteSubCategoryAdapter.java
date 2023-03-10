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

class SQLiteSubCategoryAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> UserName;

    public SQLiteSubCategoryAdapter(Context context, ArrayList<String> name_arrayList) {
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
        SQLiteSubCategoryAdapter.Holder_class holder;
        LayoutInflater inflater;
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_category, null);
            holder = new SQLiteSubCategoryAdapter.Holder_class();
            holder.name = (TextView) view.findViewById(R.id.txtHeading);
            view.setTag(holder);
        } else {
            holder = (SQLiteSubCategoryAdapter.Holder_class) view.getTag();
        }
        holder.name.setText(UserName.get(position));

        return view;
    }

    public class Holder_class {
        TextView name;
    }

    public void filterText(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        CivilLawsCategories.Name_ArrayList.clear();
        FemaleProtectionCategories.Name_List.clear();
        CyberLawsCategories.Name_List.clear();
        if (charText.length() == 0) {
            CivilLawsCategories.Name_ArrayList.addAll(UserName);
            FemaleProtectionCategories.Name_List.addAll(UserName);
            CyberLawsCategories.Name_List.addAll(UserName);
        } else {
            for (String mp : UserName) {
                if (mp.toLowerCase(Locale.getDefault()).contains(charText)) {
                    CivilLawsCategories.Name_ArrayList.add(mp);
                    FemaleProtectionCategories.Name_List.add(mp);
                    CyberLawsCategories.Name_List.add(mp);
                }
            }
            notifyDataSetChanged();

        }
    }
}
