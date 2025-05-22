package com.aoi.Mastercopy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Collection {

    private String id;
    private String name;
    // TODO TIFF: This should be a set or a hashmap or something instead
    private ArrayList<String> savedArt;

    public Collection() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getSavedArt() {
        return savedArt;
    }

    public void setSavedArt(ArrayList<String> savedArt) {
        this.savedArt = savedArt;
    }

    // TODO TIFF: How do I the builder pattern again?
}