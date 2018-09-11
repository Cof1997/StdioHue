package com.cof.stdio_hue.appcontacts.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cof.stdio_hue.appcontacts.R;
import com.cof.stdio_hue.appcontacts.databinding.ItemProfileBinding;
import com.cof.stdio_hue.appcontacts.model.Profile;

import java.util.List;

/**
 * Created by Cof on 05/09/2018.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<Profile> profiles;

    private LayoutInflater layoutInflater;
    private Context mContext;

    private ItemProfileBinding itemProfileBinding;

    public MyAdapter(List<Profile> list){
        this.profiles = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewTyoe) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        itemProfileBinding = DataBindingUtil.inflate(layoutInflater.from(viewGroup.getContext()),R.layout.item_profile, viewGroup, false);
        return new MyViewHolder(itemProfileBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.setBinding(profiles.get(position), position);
    }


    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ObservableField<Integer> mID = new ObservableField<>();
        public ObservableField<String> mName = new ObservableField<>();
        public ObservableField<String> mPhone = new ObservableField<>();

        private ItemProfileBinding mItemProfileBinding = itemProfileBinding;

        public MyViewHolder(ItemProfileBinding itemView) {
            super(itemView.getRoot());
            this.mItemProfileBinding = itemView;
        }
        public void setBinding(Profile profile, int position) {
            mID.set(profile.getmID());
            mName.set(profile.getmName());
            mPhone.set(profile.getmPhoneNumber());
        }
    }
}
