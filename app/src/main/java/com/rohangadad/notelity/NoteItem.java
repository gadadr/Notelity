package com.rohangadad.notelity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.annotation.SuppressLint;
/**
 * Created by Rohan on 3/31/15.
 */

public class NoteItem implements Serializable {

    private String key;
    private String text;

    public static final String TEXT = "text";
    public static final String KEY = "key";

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @SuppressLint("SimpleDateFormat")
    public static NoteItem getNew() {

        Locale locale = new Locale("en_US");
        Locale.setDefault(locale);

        String pattern = "yyyy-MM-dd HH:mm:ss Z";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String key = formatter.format(new Date());

        NoteItem note = new NoteItem();
        note.setKey(key);
        note.setText("");
        return note;

    }

    @Override
    public String toString() {
        return this.getText();
    }

}
