package com.cof.stdio_hue.contacts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cof.stdio_hue.contacts.R;
import com.cof.stdio_hue.contacts.adapter.vh.ItemListVH;
import com.cof.stdio_hue.contacts.model.Profile;

import java.util.List;

/**
 * Created by Cof on 02/09/2018.
 */
public class AdapterListProfile extends RecyclerView.Adapter<ItemListVH> {

    private List<Profile> mProfile;

    public AdapterListProfile(List<Profile> profile){
        this.mProfile = profile;
    }

    @Override
    public ItemListVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View viewProfile = inflater.inflate(R.layout.item_list_profile, viewGroup, false);
        return new ItemListVH(viewProfile);
    }

    @Override
    public void onBindViewHolder(ItemListVH itemListVH, int position) {
        Profile profile = mProfile.get(position);

        TextView tvID = itemListVH.tvID;
        TextView tvName = itemListVH.tvName;
        TextView tvPhoneNumber = itemListVH.tvPhoneNumber;
        TextView tvAddress = itemListVH.tvAddress;
        TextView tvEmail = itemListVH.tvEmail;

        tvID.setText(Integer.valueOf(profile.getmID()).toString());
        tvName.setText(profile.getmName().toString());
        tvPhoneNumber.setText(profile.getmPhoneNumber().toString());
        tvAddress.setText(profile.getmAddress().toString());
        tvEmail.setText(profile.getmEmail().toString());

    }

    @Override
    public int getItemCount() {
        return mProfile.size();
    }

    public static OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }

    //--------

    public static OnItemLongClickListener longClickListener;

    public interface OnItemLongClickListener {
        boolean onItemLongClick(View itemView,int position);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mLongClickListener) {
        this.longClickListener = mLongClickListener;
    }
}
