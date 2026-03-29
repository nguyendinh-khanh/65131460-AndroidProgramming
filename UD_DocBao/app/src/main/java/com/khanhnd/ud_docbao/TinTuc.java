package com.khanhnd.ud_docbao;

public class TinTuc {
    String title, link, pubDate, imageUrl;
    //contructor
    public TinTuc(String title, String pubDate, String imageUrl) {
        this.title = title;
        this.pubDate = pubDate;
        this.imageUrl = imageUrl;
    }

    //getter và setter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
