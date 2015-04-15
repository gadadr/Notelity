package com.rohangadad.notelity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Rohan on 4/13/2015.
 */
public class MyAdapter extends ArrayAdapter {

    static int[] randomColors = new int[2];;

    public MyAdapter(Context context, int resource1, int resource2, List objects) {
        super(context, resource1, resource2, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        int[] colors = new int[] {Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA,
        Color.BLACK, Color.CYAN};

        if (position % 2 == 0) {
            view.setBackgroundColor(colors[getRandomColors()]);
        } else {
            view.setBackgroundColor(colors[getRandomColors()]);
        }

        return view;
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
