package com.ayesha.judicial_provision.Lawyers_Portal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ayesha.judicial_provision.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LawyerAdapter extends BaseAdapter {
    private List<lawyer> dataset = new ArrayList<>();
    private final ArrayList<lawyer> arraylist;
    private Context context;
    private  static LayoutInflater inflater=null;

    public LawyerAdapter(List<lawyer> dataset, Context context){
        this.dataset=dataset;
        this.context=context;
        inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arraylist = new ArrayList<lawyer>();
        this.arraylist.addAll(Lawyerlistview.lawyerArrayList);
    }


    public class ViewHolder { TextView name,phoneNo, speciality;}
    @Override
    public int getCount() { return Lawyerlistview.lawyerArrayList.size(); }

    @Override
    public Object getItem(int position) { return Lawyerlistview.lawyerArrayList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final ViewHolder holder ;
        if(view==null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.lawyer_list_textview, null);
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.phoneNo=(TextView)view.findViewById(R.id.phno);
            holder.speciality=(TextView)view.findViewById(R.id.specialty);
            view.setTag(holder);
        }
        else{
            holder=(ViewHolder)view.getTag();
        }
        holder.name.setText(Lawyerlistview.lawyerArrayList.get(position).getName());
        holder.phoneNo.setText(Lawyerlistview.lawyerArrayList.get(position).getNumber());
        holder.speciality.setText(Lawyerlistview.lawyerArrayList.get(position).getSpeciality());
        return view;
    }

    public void filter(String charText){
        charText=charText.toLowerCase(Locale.getDefault());
        Lawyerlistview.lawyerArrayList.clear();
        if(charText.length()==0){
            Lawyerlistview.lawyerArrayList.addAll(arraylist);
        }
        else{
            for(lawyer mp: arraylist){
                if (mp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    Lawyerlistview.lawyerArrayList.add(mp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
