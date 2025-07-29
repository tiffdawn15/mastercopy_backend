package com.aoi.Mastercopy.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Objects;

@Document(collection = "collection")
public class Collection {
    @Id
    private ObjectId id;
    private String name;
    // TODO TIFF: This should be a set or a hashmap or something instead
    private ArrayList<String> savedArt;

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

    public ArrayList<String> getSavedArt() {
        return savedArt;
    }

    public void setSavedArt(ArrayList<String> savedArt) {
        this.savedArt = savedArt;
    }

    // TODO TIFF: How do I the builder pattern again?


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(savedArt, that.savedArt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, savedArt);
    }
}