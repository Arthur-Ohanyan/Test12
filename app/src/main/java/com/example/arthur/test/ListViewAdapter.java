package com.example.arthur.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

class yourAdapter extends BaseAdapter {

    Context context;
    Spinner spinner;
    //String qanak;
    String tesak;
    Main3Activity main3Activity;
    List<String> cucak= new ArrayList<>();
    List<String> qanak= new ArrayList<>();

    public yourAdapter(Context context1, List<String> cucak1, List<String>  qanak1) {

        context = context1;
        cucak = cucak1;
        qanak = qanak1;
    }


    @Override
    public int getCount() {

        return  cucak.size();

    }

    @Override
    public Object getItem(int i) {
        return cucak.get(i);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        View vi = convertView;



        if (vi == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            vi = inflater.inflate(R.layout.list_view_item, null);


        }
        TextView text_tesak = vi.findViewById(R.id.txt_tesak);
        text_tesak.setText(cucak.get(position));

        EditText text_qanak = vi.findViewById(R.id.txt_qanak);
        text_qanak.setText(qanak.get(position));




        ImageButton delet = vi.findViewById(R.id.delet);

        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cucak.remove(position) ;
                qanak.remove(position);
                notifyDataSetChanged() ;
            }
        });

        return vi;


    }
}