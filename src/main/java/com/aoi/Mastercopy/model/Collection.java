package com.aoi.Mastercopy.model;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Collection class representing a collection of saved art pieces.
 */
public class Collection {

    private ObjectId id;
    private String name;
    private HashSet<String> savedArt;

    public Collection() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Collection name(String name) {
        this.name= name;
        return this;
    }

    public HashSet<String> getSavedArt() {
        return savedArt;
    }

    public void setSavedArt(HashSet<String> savedArt) {
        this.savedArt = savedArt;
    }

    private Collection savedArt(HashSet<String> savedArt) {
        this.savedArt = savedArt;
        return this;
    }
}