package com.example.mobileapp.ui.model;

public class Note {

    private String title;
    private String description;
    private boolean isChecked;

    public Note(String title, String description, boolean isChecked) {
        this.title = title;
        this.description = description;
        this.isChecked = isChecked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        String prefix = isChecked ? "Done: " : "To do: ";
        return prefix + title + ". " + description;
    }
}
