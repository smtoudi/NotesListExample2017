package oo.max.noteslistexample.list;

import android.os.AsyncTask;

import java.util.List;

import oo.max.noteslistexample.apiclient.NotesApiClient;
import oo.max.noteslistexample.apiclient.RetrofitApiClientFactory;
import oo.max.noteslistexample.model.NoteListItem;
import oo.max.noteslistexample.model.NotesListResponse;
import retrofit2.Response;

public class GetNotesListAsyncTask extends AsyncTask<Void, Void, List<NoteListItem>> {

    private final NotesApiClient notesApiClient;
    private final OnNotesDownloadListener onNotesDownloadListener;

    public GetNotesListAsyncTask(OnNotesDownloadListener onNotesDownloadListener) {
        this.onNotesDownloadListener = onNotesDownloadListener;
        notesApiClient = new RetrofitApiClientFactory().create();
    }

    @Override
    protected List<NoteListItem> doInBackground(Void... voids) {
        try {
            Response<NotesListResponse> response = notesApiClient.getNotes().execute();
            if(response.isSuccessful()) {
                return response.body().getData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<NoteListItem> noteListItems) {
        onNotesDownloadListener.notesDownloaded(noteListItems);
    }

    public interface OnNotesDownloadListener {
        void notesDownloaded(List<NoteListItem> noteListItems);
    }
}
