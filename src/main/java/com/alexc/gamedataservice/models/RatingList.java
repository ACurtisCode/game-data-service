package com.alexc.gamedataservice.models;

import java.util.ArrayList;
import java.util.List;

public class RatingList {
    private List<Rating> gameList;

    public RatingList() {
    }

    public RatingList(List<Rating> gameList) {

        this.gameList = gameList;
    }

    public List<Rating> getGameList() {
        return gameList;
    }

    public void setGameList(List<Rating> gameList) {
        this.gameList = gameList;
    }
}
