package oo.max.noteslistexample.apiclient;

import android.widget.TextView;

import oo.max.noteslistexample.model.NotesListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NotesApiClient {

    @GET("/plugin/notes.list")
    Call<NotesListResponse> getNotes();

    @GET("/plugin/notes.list")
    Call<NoteDetailRespons> getNoteDatails(@Query("id")String id);

TextView=(TextView) final
    class NoteDetailRespons {
    }
}