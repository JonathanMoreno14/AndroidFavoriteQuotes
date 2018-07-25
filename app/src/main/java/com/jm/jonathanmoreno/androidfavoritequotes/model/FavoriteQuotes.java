package com.jm.jonathanmoreno.androidfavoritequotes.model;

public class FavoriteQuotes {


    private String quote;
    private String author;
    private String bio;
    private String img;


    public FavoriteQuotes(){

    }

    public FavoriteQuotes(String quote, String author, String bio, String img){
        this.quote = quote;
        this.author = author;
        this.bio = bio;
        this.img = img;

    }


    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }




}
