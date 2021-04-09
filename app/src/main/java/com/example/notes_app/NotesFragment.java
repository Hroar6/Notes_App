package com.example.notes_app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NotesFragment extends Fragment {
    private boolean isLandscape;
    private NotesInfo notesInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
//        String[] name = getResources().getStringArray(R..cities);
        NotesInfo[] notesInfo = new NotesInfo[3];
        notesInfo[0] = new NotesInfo("name1", "something1");
        notesInfo[1] = new NotesInfo("name2", "something2");
        notesInfo[2] = new NotesInfo("name3", "something3");

        for (int i = 0; i < notesInfo.length; i++) {
            String name = notesInfo[i].getName();
            TextView tv = new TextView(getContext());
            tv.setText(name);
            tv.setTextSize(30);
            layoutView.addView(tv);
            final int fi = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCoatOfArms(fi);
                }
            });
        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        if (isLandscape) {
            showLandCoatOfArms(0);
        }
    }

    private void showCoatOfArms(int index) {
        if (isLandscape) {
            showLandCoatOfArms(index);
        } else {
            showPortCoatOfArms(index);
        }
    }


    private void showLandCoatOfArms(int index) {
        OpenNoteFragment detail = OpenNoteFragment.newInstance();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.noteDescription, detail);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
    private void showPortCoatOfArms(int index) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), OpenNoteActivity.class);
        intent.putExtra(OpenNoteFragment.ARG_NOTESINFO, index);
        startActivity(intent);
    }
}
