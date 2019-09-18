package com.example.instagramclone.model;

public class Post {

    private User user;
    private String postImage, postLegend;
    private int likes;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getPostLegend() {
        return postLegend;
    }

    public void setPostLegend(String postLegend) {
        this.postLegend = postLegend;
    }
}
