package com.cof.stdio_hue.fragment;

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
import android.widget.Toast;

public class Fragment1  extends Fragment{
    TextView txtFrm1;
    EditText edtFrm1;
    Button btnFrm1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        txtFrm1 = (TextView) view.findViewById(R.id.textViewFragment1);
        edtFrm1 = (EditText) view.findViewById(R.id.editTextFragment1);
        btnFrm1 = (Button) view.findViewById(R.id.buttonFragment1);

        btnFrm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), edtFrm1.getText().toString(), Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
            }
        });
        return view;
    }
}
