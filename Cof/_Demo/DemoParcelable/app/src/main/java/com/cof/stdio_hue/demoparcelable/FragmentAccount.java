package com.cof.stdio_hue.demoparcelable;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentAccount extends Fragment {
    ImageView imageView;
    TextView tvName, tvAddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        Bundle bundle = getArguments();
        if(bundle != null){
            AccountItem accountItem = bundle.getParcelable("KEY");

            imageView = (ImageView) view.findViewById(R.id.image_fragment);
            imageView.setImageResource(accountItem.getImage());

            tvName = (TextView) view.findViewById(R.id.textViewName_fragment);
            tvName.setText(accountItem.getName());

            tvAddress = (TextView) view.findViewById(R.id.textViewAddress_fragment);
            tvAddress.setText(accountItem.getAddress());
        }
        return view;
    }
}
