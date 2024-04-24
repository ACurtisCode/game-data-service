package com.alexc.gamedataservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private Long id;

    private String name;

    @JsonIgnore
    private List<Game> gamesWithTag = new ArrayList<>();

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGamesWithTag() {
        return gamesWithTag;
    }

    public void setGamesWithTag(List<Game> gamesWithTag) {
        this.gamesWithTag = gamesWithTag;
    }
}
