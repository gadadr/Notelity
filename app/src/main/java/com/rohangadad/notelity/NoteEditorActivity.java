package com.rohangadad.notelity;

/**
 * Created by Rohan on 3/31/2015.
 */

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.EditText;

public class NoteEditorActivity extends ActionBarActivity {

    private NoteItem note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = this.getIntent();
        note = new NoteItem();
        note.setKey(intent.getStringExtra("key"));
        note.setText(intent.getStringExtra("text"));

        EditText et = (EditText) findViewById(R.id.noteText);
        et.setText(note.getText());
        et.setSelection(note.getText().length());
    }

    private void saveAndFinish() {
        EditText et = (EditText) findViewById(R.id.noteText);
        String noteText = et.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("key", note.getKey());
        intent.putExtra("text", noteText);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            saveAndFinish();
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        saveAndFinish();
    }

}

