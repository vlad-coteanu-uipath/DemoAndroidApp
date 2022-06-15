package com.example.mobileapp.ui.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapp.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private TextView txtTitle;
    private TextView txtDescription;
    private CheckBox checkIsDone;

    public NoteViewHolder(View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.tvTitle);
        txtDescription = itemView.findViewById(R.id.tvDescription);
        checkIsDone = itemView.findViewById(R.id.ckIsDone);

    }

    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    public void setDescription(String description) {
        txtDescription.setText(description);
    }

    public void setChecked(boolean isChecked) {
        checkIsDone.setChecked(isChecked);
    }
}
