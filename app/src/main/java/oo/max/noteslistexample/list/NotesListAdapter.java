package oo.max.noteslistexample.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import oo.max.noteslistexample.R;
import oo.max.noteslistexample.model.NoteListItem;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.NotesItemViewHolder> {

    private final Context context;
    private final List<NoteListItem> noteListItems;
    private final LayoutInflater layoutInflater;
    private final OnNoteClikedListner onNoteClikedListner;


    public NotesListAdapter(Context context, List<NoteListItem> noteListItems, OnNoteClikedListner onNoteClikedListner) {
        this.context = context;
        this.noteListItems = noteListItems;
        layoutInflater = LayoutInflater.from(context);
        this.onNoteClikedListner = onNoteClikedListner;
    }

    @Override
    public NotesItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.notes_list_item, parent, false);
        return new NotesItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesItemViewHolder holder, int position) {
        NoteListItem noteListItem = noteListItems.get(position);

        holder.noteNameText.setText(noteListItem.getName());
        holder.noteListItem = noteListItem;
    }

    @Override
    public int getItemCount() {
        return noteListItems.size();
    }

    public static class NotesItemViewHolder extends RecyclerView.ViewHolder {

        TextView noteNameText;
        NoteListItem noteListItem;

        public NotesItemViewHolder(View itemView, final OnNoteClikedListner onNoteClikedListner) {
            super(itemView);
            noteNameText = (TextView) itemView.findViewById(R.id.note_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNoteClikedListner.noteCliked(noteListItem);

                }
            });
        }

        public NotesItemViewHolder(View view) {
            super(view);
        }
    }
    public interface OnNoteClikedListner {
        void noteCliked(NoteListItem noteListItem);
    }
}
