package com.aoi.Mastercopy.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "collection", path = "collection")
public interface CollectionRepository extends MongoRepository<Collection, String> {

    List<Collection> findByName(@Param("name") String name);

}