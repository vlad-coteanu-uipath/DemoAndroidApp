package com.example.mobileapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapp.R;
import com.example.mobileapp.ui.model.Note;
import com.example.mobileapp.ui.viewholder.NoteViewHolder;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private List<Note> noteList;
    private Context mContext;

    public NoteAdapter(List<Note> contactsList, Context context) {
        this.noteList = contactsList;
        this.mContext = context;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.note_card, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        final Note note = noteList.get(position);

        // Set the data to the views here
        holder.setTitle(note.getTitle());
        holder.setDescription(note.getDescription());
        holder.setChecked(note.isChecked());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, noteList.get(holder.getAdapterPosition()).toString());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                mContext.startActivity(shareIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return noteList == null? 0: noteList.size();
    }
}
