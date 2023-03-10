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

public class SqLiteLawsAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> LawName;
    ArrayList<String> LawNumber;

    public SqLiteLawsAdapter(Context context, ArrayList<String> number_List
            ,ArrayList<String> name_arrayList) {
        this.context = context;
        this.LawNumber=number_List;
        this.LawName = name_arrayList;

    }

    @Override
    public int getCount() {
        return LawName.size();
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
       SqLiteLawsAdapter.Holder_class holder;
        LayoutInflater inflater;
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.laws_txt, null);
            holder = new SqLiteLawsAdapter.Holder_class();
            holder.number=(TextView) view.findViewById(R.id.law_no);
            holder.name = (TextView) view.findViewById(R.id.law_name);

            view.setTag(holder);
        } else {
            holder = (SqLiteLawsAdapter.Holder_class) view.getTag();
        }

        holder.number.setText(LawNumber.get(position));
        holder.name.setText(LawName.get(position));

        return view;
    }

    public class Holder_class {
        TextView number;
        TextView name;

    }

    public void filterText(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());





        if (charText.length() == 0) {


        } else {
            for (String mp : LawName) {
                if (mp.toLowerCase(Locale.getDefault()).contains(charText)) {


                }
            }
            notifyDataSetChanged();

        }
    }
}
