package com.rohangadad.notelity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rohan on 4/13/2015.
 */
public class MyAdapter extends ArrayAdapter {


    public MyAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        int[] colors = new int[] {Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA};

        if (position % 5 == 0) {
            view.setBackgroundColor(colors[0]);
        } else if (position % 5 == 1) {
            view.setBackgroundColor(colors[1]);
        } else if (position % 5 == 2) {
            view.setBackgroundColor(colors[2]);
        } else if (position % 5 == 3) {
            view.setBackgroundColor(colors[3]);
        } else {
            view.setBackgroundColor(colors[4]);
        }

        return view;
    }
}
