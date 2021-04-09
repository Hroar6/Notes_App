package com.example.notes_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OpenNoteFragment extends Fragment {
    public static final String ARG_NOTESINFO = "index";
    private NotesInfo notesInfo;

    public static OpenNoteFragment newInstance(NotesInfo notesInfo) {
        OpenNoteFragment f = new OpenNoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTESINFO, notesInfo);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            notesInfo = getArguments().getParcelable(ARG_NOTESINFO);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_open_notes, container, false);
        TextView noteDescription = view.findViewById(R.id.noteDescription);
        noteDescription.setText("something");
        return view;
    }
}

