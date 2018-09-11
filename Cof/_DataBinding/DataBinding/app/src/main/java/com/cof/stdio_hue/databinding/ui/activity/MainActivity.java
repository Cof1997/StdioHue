package com.cof.stdio_hue.databinding.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.cof.stdio_hue.databinding.R;
import com.cof.stdio_hue.databinding.adapter.PostAdapter;
import com.cof.stdio_hue.databinding.databinding.ActivityMainBinding;
import com.cof.stdio_hue.databinding.model.Post;
import com.cof.stdio_hue.databinding.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PostAdapter.PostsAdapterListener {

    private User user;
    private PostAdapter mAdapter;
    private ActivityMainBinding binding;
    private MyClick myClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initProfile();
        initRecyclerView();

        myClick = new MyClick();
        binding.setClick(myClick);
    }

    private void initRecyclerView(){
        mAdapter = new PostAdapter(getPost(), this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(mAdapter);
    }

    private ArrayList<Post> getPost(){
        ArrayList<Post> listPost = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            Post post = new Post();
            post.setImageUrl("https://api.androidhive.info/images/nature/" + i + ".jpg");
            listPost.add(post);
        }
        return listPost;
    }

    @Override
    public void onPostClicked(Post post) {
        Toast.makeText(this,"Post Clicked",Toast.LENGTH_SHORT).show();
    }

    public class MyClick{
        public MyClick(){
        }

        public void onClickLike(View view, User user){
            Toast.makeText(view.getContext(),"Like: " + user.getNumberOfLike().get(), Toast.LENGTH_SHORT).show();
        }

        public void onClickShare(View view, User user){
            Toast.makeText(view.getContext(),"Share: " + user.getNumberOfShare().get(), Toast.LENGTH_SHORT).show();
        }

    }

    private void initProfile(){
        user = new User();
        user.setUserName("Ducky");
        user.setEmail("Aboypham@gmail.com");
        user.setProfileImage("http://i.imgur.com/rZU44hU.png");

        user.getNumberOfLike().set(123456L);
        user.getNumberOfShare().set(11111L);

        binding.setUser(user);
    }
}
