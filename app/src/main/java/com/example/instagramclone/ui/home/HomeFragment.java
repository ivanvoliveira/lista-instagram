package com.example.instagramclone.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.instagramclone.MainActivity;
import com.example.instagramclone.R;
import com.example.instagramclone.adapter.PostAdapter;
import com.example.instagramclone.adapter.UserAdapter;
import com.example.instagramclone.model.Post;
import com.example.instagramclone.model.User;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<User> users = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private String link = "https://scontent.fitp1-1.fna.fbcdn.net/v/t1.0-9/62599874_1347423122074936_8018115376493625344_n.jpg?_" +
            "nc_cat=101&_nc_oc=AQm5xoBBwuUhsvvbnWoh8PVkOTwUEW23D6JgSA4fw4sXADCTTxsYJpHtXIX9nVX2Od0&_nc_ht=scontent.fitp1-1.fna&oh=" +
            "80c5d049c04e4bc915e6bb6251a7151d&oe=5DF2E2EC";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setHasOptionsMenu(true);

        //Cria stories
        User user = new User();
        user.setProfileImage(link);
        user.setUsername("ivanviana_");

        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);

        //Cofigura RecyclerView e Adapter do Stories
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_story);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        UserAdapter adapter = new UserAdapter(users, getContext());
        recyclerView.setAdapter(adapter);

        //Cria posts
        Post post = new Post();
        post.setLikes(247);
        post.setPostImage(link);
        post.setPostLegend("Legenda o/");
        post.setUser(user);

        posts.add(post);
        posts.add(post);
        posts.add(post);
        posts.add(post);
        posts.add(post);
        posts.add(post);
        posts.add(post);
        posts.add(post);

        //Configura recycler e adapter dos posts
        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView_post);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        PostAdapter adapter1 = new PostAdapter(posts, getContext());
        recyclerView1.setAdapter(adapter1);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Instagram");
        ((MainActivity) getActivity()).setActionBarIcon(R.drawable.ic_camera);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}