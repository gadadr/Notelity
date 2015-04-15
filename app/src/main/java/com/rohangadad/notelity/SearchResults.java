package com.rohangadad.notelity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rohan on 4/14/2015.
 */
public class SearchResults extends ListActivity {

    private static final int EDITOR_ACTIVITY_REQUEST = 1001;
    ArrayList<NoteItem> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle args = getIntent().getBundleExtra("BUNDLE");
        notesList= (ArrayList<NoteItem>) args.getSerializable("ARRAYLIST");

        String query = args.getString("Query");
        List<String> noteTitles = new ArrayList<>();

        for (int i=0; i<notesList.size(); i++) {
            NoteItem item = notesList.get(i);
            if (item.getText().toLowerCase().contains(query.toLowerCase())) {
                String lines[] = item.getText().split("\\r?\\n");
                String temp = lines[0];
                noteTitles.add(temp);
            }
        }

        ArrayAdapter<String> adapter = new MyAdapter(this, R.layout.list_item_layout, noteTitles);
        setListAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            saveAndFinish();
        }
        return false;

    }

    private void saveAndFinish() {
        Intent intent = new Intent(SearchResults.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        saveAndFinish();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        NoteItem note = notesList.get(position);
        Intent intent = new Intent(this, NoteEditorActivity.class);
        intent.putExtra("key", note.getKey());
        intent.putExtra("text", note.getText());
        startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST);
    }

}
