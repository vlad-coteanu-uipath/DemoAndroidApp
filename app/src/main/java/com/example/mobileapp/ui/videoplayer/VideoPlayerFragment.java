package com.example.mobileapp.ui.videoplayer;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobileapp.R;
import com.example.mobileapp.databinding.FragmentVideoplayerBinding;

public class VideoPlayerFragment extends Fragment {

    private FragmentVideoplayerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VideoPlayerViewModel videoPlayerViewModel =
                new ViewModelProvider(this).get(VideoPlayerViewModel.class);

        binding = FragmentVideoplayerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        super.onCreate(savedInstanceState);
        VideoView videoView = binding.vdVw;
        MediaController mediaController= new MediaController(getActivity());
        mediaController.setAnchorView(videoView);

        // preSaveMediaFile();

        //Location of Media File
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.avenger);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}