package com.example.mobileapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapp.R;
import com.example.mobileapp.databinding.FragmentHomeBinding;
import com.example.mobileapp.ui.adapter.NoteAdapter;
import com.example.mobileapp.ui.model.Note;

import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private NoteAdapter noteAdapter;
    private RecyclerView noteRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initializeNotesRecycleView();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initializeNotesRecycleView() {
        noteRecyclerView = binding.tripRecyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        noteRecyclerView.setLayoutManager(layoutManager);

        noteAdapter = new NoteAdapter(getMockedData(), getActivity());
        noteRecyclerView.setAdapter(noteAdapter);
    }

    private List<Note> getMockedData() {
        Note[] data = {
                new Note("Doctor appointment", "On 12-10-2022 I have an appointment at a cardiologist", true),
                new Note("Shopping", "I have to go shopping at LIDL", false),
                new Note("Cat to vet", "I have to take the cat to the vet", true)
        };

        return Arrays.asList(data);
    }
}