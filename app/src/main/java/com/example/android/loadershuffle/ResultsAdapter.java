package com.example.android.loadershuffle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsAdapter extends ArrayAdapter<Results> {

    public ResultsAdapter(Activity context, ArrayList<Results> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.results_list, parent, false);
        }

        Results currentResult = getItem(position);

        //Assigns value to the Title TextView
        /* TextView titleView = (TextView) convertView.findViewById(R.id.item_title);
        titleView.setText(currentResult.getName()); */

        //Assigns value to the Author TextView
        TextView authorView = (TextView) convertView.findViewById(R.id.primary_numbers);
        authorView.setText(currentResult.getPrimaryNumbers());

        //Assigns value to the Identifier TextView
        TextView identifierView = (TextView) convertView.findViewById(R.id.bonus_numbers);
        identifierView.setText(currentResult.getBonusNumbers());

        return convertView;
    }

}
