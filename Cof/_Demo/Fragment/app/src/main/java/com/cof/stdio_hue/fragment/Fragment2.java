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

public class Fragment2  extends Fragment{
    TextView txtFrm2;
    EditText edtFrm2;
    Button btnFrm2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_2, container, false);
        txtFrm2 = (TextView) view.findViewById(R.id.textViewFragment2);
        edtFrm2 = (EditText) view.findViewById(R.id.editTextFragment2);
        btnFrm2 = (Button) view.findViewById(R.id.buttonFragment2);

        Bundle bundle = getArguments();
        if(bundle != null){
            edtFrm2.setText(bundle.getString("Data_Send"));
        }

        btnFrm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), edtFrm2.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}