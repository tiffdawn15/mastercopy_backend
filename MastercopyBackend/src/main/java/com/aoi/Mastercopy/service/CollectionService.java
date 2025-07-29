package com.aoi.Mastercopy.service;

import com.aoi.Mastercopy.dto.CollectionDTO;
import com.aoi.Mastercopy.model.Collection;
import com.aoi.Mastercopy.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public boolean createCollection(CollectionDTO collectionDTO){
        if (collectionDTO == null || collectionDTO.getName() == null || collectionDTO.getName().isEmpty()) {
            return false;
        }

        // TODO TIFF: Update with Builder pattern
        Collection collection = new Collection();
        collection.setName(collectionDTO.getName());

        try {
            collectionRepository.save(collection);
            return true; // Collection created successfully
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error occurred while creating the collection
        }
    }
}
