package com.cof.stdio_hue.send_data;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentA extends Fragment {

    TextView tvA;
    EditText etA;
    Button btnA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        tvA = (TextView) view.findViewById(R.id.tv_fmA);
        etA = (EditText) view.findViewById(R.id.et_fmA);
        btnA = (Button) view.findViewById(R.id.btn_fmA);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvHome = (TextView) getActivity().findViewById(R.id.tv_Home);
                tvHome.setText(etA.getText().toString());
            }
        });
        return view;
    }

}
