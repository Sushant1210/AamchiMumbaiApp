package com.example.firstminiproject;

public class Gallery {
    private int id;
    private String imgUrl;
    private String title;
    private int image;

    public Gallery(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public Gallery(int id, String imgUrl, String title) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
