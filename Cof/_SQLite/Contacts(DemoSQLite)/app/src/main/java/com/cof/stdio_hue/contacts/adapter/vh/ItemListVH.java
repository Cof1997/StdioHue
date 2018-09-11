package com.cof.stdio_hue.contacts.adapter.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cof.stdio_hue.contacts.R;

import static com.cof.stdio_hue.contacts.adapter.AdapterListProfile.clickListener;
import static com.cof.stdio_hue.contacts.adapter.AdapterListProfile.longClickListener;

/**
 * Created by Cof on 04/09/2018.
 */
public class ItemListVH extends RecyclerView.ViewHolder{

    public TextView tvID;
    public TextView tvName;
    public TextView tvPhoneNumber;
    public TextView tvAddress;
    public TextView tvEmail;


    public ItemListVH(final View itemView) {
        super(itemView);

        tvID = (TextView) itemView.findViewById(R.id.tv_item_id);
        tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
        tvPhoneNumber = (TextView) itemView.findViewById(R.id.tv_item_phone_number);
        tvAddress = (TextView) itemView.findViewById(R.id.tv_item_address);
        tvEmail = (TextView) itemView.findViewById(R.id.tv_item_email);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null)
                    clickListener.onItemClick(itemView, getLayoutPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClickListener != null){
                    longClickListener.onItemLongClick(itemView, getLayoutPosition());
                    return true;
                }
                return false;
            }
        });

    }

}
