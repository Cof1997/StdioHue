package com.cof.stdio_hue.databinding.adapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cof.stdio_hue.databinding.R;
import com.cof.stdio_hue.databinding.adapter.vh.ItemPostVH;
import com.cof.stdio_hue.databinding.databinding.ItemPostBinding;
import com.cof.stdio_hue.databinding.model.Post;

import java.util.List;

/**
 * Created by Cof on 10/09/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<ItemPostVH> {

    private List<Post> postList;
    private PostsAdapterListener postsAdapterListener;
    private LayoutInflater layoutInflater;

    public PostAdapter(List<Post> postList,PostsAdapterListener listener) {
        this.postList = postList;
        this.postsAdapterListener = listener;
    }

    @NonNull
    @Override
    public ItemPostVH onCreateViewHolder(@NonNull ViewGroup viewGroup,int i) {
        if(layoutInflater == null)
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ItemPostBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_post, viewGroup,false);
        return new ItemPostVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPostVH itemPostVH,int postion) {
        itemPostVH.bind(postList.get(postion));
    }

    @Override
    public int getItemCount() {
        return postList == null ? 0 : postList.size();
    }


    public interface PostsAdapterListener {
        void onPostClicked(Post post);
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView,String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }

    @BindingAdapter({"profileImage"})
    public static void loadProfileImage(ImageView imageView, String profileImageUrl) {
        Glide.with(imageView.getContext())
                .load(profileImageUrl)
                .into(imageView);
    }
}
