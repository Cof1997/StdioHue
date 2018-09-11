package com.cof.stdio_hue.fragment_remove_popbackstack;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "onCreateView Fragment A", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onStart() {
        Toast.makeText(getActivity(), "onStart Fragment A", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    public void onResume() {
        Toast.makeText(getActivity(), "onResume Fragment A", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    public void onPause() {
        Toast.makeText(getActivity(), "onPause Fragment A", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    public void onStop() {
        Toast.makeText(getActivity(), "onStop Fragment A", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Toast.makeText(getActivity(), "onDestroyView Fragment A", Toast.LENGTH_SHORT).show();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getActivity(), "onDestroy Fragment A", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
