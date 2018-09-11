package com.cof.stdio_hue.demoparcelable;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountViewHolder> {
    private ArrayList<AccountItem> mAccountList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class AccountViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextName;
        public TextView mTextAddress;

        public AccountViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextName = itemView.findViewById(R.id.textViewName);
            mTextAddress = itemView.findViewById(R.id.textViewAddress);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public AccountAdapter(ArrayList<AccountItem> accountList) {
       mAccountList = accountList;
    }

    @Override
    public AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item, parent, false);
        AccountViewHolder evh = new AccountViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(AccountViewHolder holder, int position) {
        AccountItem currentItem = mAccountList.get(position);

        holder.mImageView.setImageResource(currentItem.getImage());
        holder.mTextName.setText(currentItem.getName());
        holder.mTextAddress.setText(currentItem.getAddress());
    }

    @Override
    public int getItemCount() {
        return mAccountList.size();
    }
}
