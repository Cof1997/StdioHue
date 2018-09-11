package com.cof.stdio_hue.databinding.adapter.vh;

import android.support.v7.widget.RecyclerView;

import com.cof.stdio_hue.databinding.databinding.ItemPostBinding;
import com.cof.stdio_hue.databinding.model.Post;

/**
 * Created by Cof on 10/09/2018.
 */


public class ItemPostVH extends RecyclerView.ViewHolder {

    private ItemPostBinding binding;

    public ItemPostVH(ItemPostBinding itemBinding) {
        super(itemBinding.getRoot());
        this.binding = itemBinding;
    }

    public void bind(Post post) {
        binding.setPost(post);
    }
}
