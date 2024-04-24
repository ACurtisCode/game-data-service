package com.alexc.gamedataservice.models;

public class Rating {
    private Long id;

    private double rating;

    private String reviewText;

    private Game reviewedGame;

    private User reviewCreator;

    public Rating() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Game getReviewedGame() {
        return reviewedGame;
    }

    public void setReviewedGame(Game reviewedGame) {
        this.reviewedGame = reviewedGame;
    }

    public User getReviewCreator() {
        return reviewCreator;
    }

    public void setReviewCreator(User reviewCreator) {
        this.reviewCreator = reviewCreator;
    }
}
