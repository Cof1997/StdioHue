package com.cof.stdio_hue.democontacts.adapter;

import com.cof.stdio_hue.democontacts.R;
import com.cof.stdio_hue.democontacts.model.Profile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cof on 04/09/2018.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHoder> {

    private ArrayList<Profile> listProfile;


    public ProfileAdapter(ArrayList<Profile> listProfile){
        this.listProfile = listProfile;
    }

    @Override
    public ProfileAdapter.ViewHoder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_profile, viewGroup, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(ViewHoder viewHoder, int position) {
        viewHoder.tvID.setText(Integer.valueOf(listProfile.get(position).getmID()));
        viewHoder.tvName.setText(listProfile.get(position).getmName().toString());
        viewHoder.tvPhoneNumber.setText(listProfile.get(position).getmPhoneNumber().toString());
        viewHoder.tvEmail.setText(listProfile.get(position).getmEmail().toString());
    }

    @Override
    public int getItemCount() {
        return listProfile.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{

        private TextView tvID;
        private TextView tvName;
        private TextView tvPhoneNumber;
        private TextView tvEmail;

        public ViewHoder(View itemView) {
            super(itemView);

            tvID = (TextView) itemView.findViewById(R.id.tv_id);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tv_phone_number);
            tvEmail = (TextView) itemView.findViewById(R.id.tv_email);
        }
    }
}
