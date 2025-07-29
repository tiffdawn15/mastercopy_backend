package com.aoi.Mastercopy.controller;

import com.aoi.Mastercopy.dto.ApiResponse;
import com.aoi.Mastercopy.model.Collection;
import com.aoi.Mastercopy.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aoi.Mastercopy.dto.CollectionDTO;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping
    public ApiResponse<List<Collection>> getAllCollections() {
        List<Collection> collections = collectionService.getAllCollections();
        return new ApiResponse<>(200, "Collections fetched successfully", collections);
    }
    @PostMapping
    public ApiResponse<Boolean> createCollection(@RequestBody CollectionDTO collectionDto) {
        Boolean bool = collectionService.createCollection(collectionDto);
        return new ApiResponse<>(201, "Collection created successfully", bool);
    }
}
