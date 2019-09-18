package com.example.instagramclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.instagramclone.R;
import com.example.instagramclone.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts;
    private Context context;

    public PostAdapter(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_post, parent, false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder vh, int position) {
        Post post = posts.get(position);

        vh.textViewUsername.setText(post.getUser().getUsername());
        vh.textViewLike.setText(post.getLikes() + " curtidas");
        vh.textViewLegend.setText(post.getPostLegend());
        vh.textViewUsernameLegend.setText(post.getUser().getUsername());
        Glide.with(context).load(post.getPostImage()).into(vh.imageViewPost);
        Glide.with(context).load(post.getUser().getProfileImage()).circleCrop().into(vh.imageViewProfile);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewPost, imageViewProfile;
        private TextView textViewUsername, textViewLike,
                textViewLegend, textViewUsernameLegend;

        public PostViewHolder(@NonNull View view) {
            super(view);

            imageViewPost = view.findViewById(R.id.imageView_post);
            imageViewProfile = view.findViewById(R.id.imageView_profile_image_post);
            textViewUsername = view.findViewById(R.id.textView_username_post);
            textViewLike = view.findViewById(R.id.textView_like_post);
            textViewLegend = view.findViewById(R.id.textView_legend);
            textViewUsernameLegend = view.findViewById(R.id.textView_username_legend);
        }
    }
}
