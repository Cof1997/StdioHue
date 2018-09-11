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

public class FragmentB extends Fragment {
    TextView tvB;
    EditText etB;
    Button btnB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        tvB = (TextView) view.findViewById(R.id.tv_fmB);
        etB = (EditText) view.findViewById(R.id.et_fmB);
        btnB = (Button) view.findViewById(R.id.btn_fmB);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvA = (TextView) getActivity().findViewById(R.id.tv_fmA);
                tvA.setText(etB.getText().toString());
            }
        });
        return view;
    }
}


