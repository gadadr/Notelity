package com.rohangadad.notelity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rohan on 4/13/2015.
 */
public class MyAdapter extends ArrayAdapter<NoteItem> {

    private Context context;
    private ArrayList<NoteItem> data;
    private int layoutResourceId;
    static int[] randomColors = new int[2];

    public MyAdapter(Context context, int layoutResourceId, ArrayList<NoteItem> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.data = data;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = null;
        int[] colors = new int[]{Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA,
                Color.BLACK, Color.CYAN};

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.textView1 = (TextView) row.findViewById(R.id.noteTitleTextView);
            holder.textView2 = (TextView) row.findViewById(R.id.noteTitleDateView);
            if (position % 2 == 0) {
                row.setBackgroundColor(colors[getRandomColors()]);
            } else {
                row.setBackgroundColor(colors[getRandomColors()]);
            }
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        NoteItem noteItem = data.get(position);
        String lines[] = noteItem.getText().split("\\r?\\n");
        String temp = lines[0];
        holder.textView1.setText(temp);
        String date = noteItem.getKey();

        String month = date.substring(5, 7);
        switch (month) {
            case "01":
                month = "Jan ";
                break;
            case "02":
                month = "Feb ";
                break;
            case "03":
                month = "Mar ";
                break;
            case "04":
                month = "Apr ";
                break;
            case "05":
                month = "May ";
                break;
            case "06":
                month = "Jun ";
                break;
            case "07":
                month = "Jul ";
                break;
            case "08":
                month = "Aug ";
                break;
            case "09":
                month = "Sep ";
                break;
            case "10":
                month = "Oct ";
                break;
            case "11":
                month = "Nov ";
                break;
            case "12":
                month = "Dec ";
                break;
        }
        String day = date.substring(8, 10);
        holder.textView2.setText(month + day);
        return row;
    }

    static class ViewHolder {
        TextView textView1;
        TextView textView2;
    }

    public int getRandomColors() {
        Random random = new Random();
        randomColors[1] = random.nextInt(7);
        if (randomColors[0] == randomColors[1]) {
            getRandomColors();
        }
        randomColors[0] = randomColors[1];
        return (randomColors[0]);
    }
}