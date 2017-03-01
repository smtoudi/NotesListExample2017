package oo.max.noteslistexample.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import oo.max.noteslistexample.R;
import oo.max.noteslistexample.model.NoteListItem;

public class NotesListActivity extends AppCompatActivity
        implements GetNotesListAsyncTask.OnNotesDownloadListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        recyclerView = (RecyclerView) findViewById(R.id.notes_list_recycler_view);

        new GetNotesListAsyncTask(this).execute();
    }

    @Override
    public void notesDownloaded(List<NoteListItem> noteListItems) {
        if(noteListItems == null) {
            Toast.makeText(this, "Failed to download notes", Toast.LENGTH_SHORT).show();
            return;
        }


        NotesListAdapter notesListAdapter = new NotesListAdapter(this, noteListItems, onNoteClikedListner);
        recyclerView.setAdapter(notesListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void noteClicked(NoteListItem noteListItem) {
        Toast.makeText(this, "note clicekd:" +noteListItem.getId(),Toast.LENGTH_SHORT);
    }
}
