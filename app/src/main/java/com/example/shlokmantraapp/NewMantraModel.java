package com.example.shlokmantraapp;

public class NewMantraModel {
    private int Image;
    private String text;

    public NewMantraModel(int image, String text) {
        Image = image;
        this.text = text;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
