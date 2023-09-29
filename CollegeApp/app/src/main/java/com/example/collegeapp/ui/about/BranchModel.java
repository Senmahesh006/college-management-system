package com.example.collegeapp.ui.about;

public class BranchModel {
    private int img;
    private String title,descriptiom;

    public BranchModel(int img, String title, String descriptiom) {
        this.img = img;
        this.title = title;
        this.descriptiom = descriptiom;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptiom() {
        return descriptiom;
    }

    public void setDescriptiom(String descriptiom) {
        this.descriptiom = descriptiom;
    }
}
