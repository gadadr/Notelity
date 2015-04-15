package com.rohangadad.notelity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class NoteEditorActivity extends Activity {

	private NoteItem note;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_editor);
		getActionBar().setDisplayHomeAsUpEnabled(true);
				
		Intent intent = this.getIntent();
		note = new NoteItem();
		note.setKey(intent.getStringExtra("key"));
		note.setText(intent.getStringExtra("text"));
		
		EditText et = (EditText) findViewById(R.id.noteText);
		et.setText(note.getText());
		et.setSelection(note.getText().length());
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_note, menu);

        return true;
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


        if (item.getItemId() == R.id.action_share) {
            EditText et = (EditText) findViewById(R.id.noteText);
            String noteText = et.getText().toString();
            noteText += "\n\n Created and shared using Notelity";

            Intent chooser = null;
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, noteText);
            chooser = shareIntent.createChooser(shareIntent, "Share");
            startActivity(chooser);

            return true;
        }
		return false;
	}
	
	@Override
	public void onBackPressed() {
		saveAndFinish();
	}
	
}
