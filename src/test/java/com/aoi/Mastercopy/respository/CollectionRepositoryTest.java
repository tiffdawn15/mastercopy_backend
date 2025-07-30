package com.aoi.Mastercopy.respository;

import com.aoi.Mastercopy.model.Collection;
import com.aoi.Mastercopy.repository.CollectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class CollectionRepositoryTest {

    @Autowired
    private CollectionRepository collectionRepository;

    @Test
    void testFindByName() {
        Collection collection = new Collection();
        collection.setName("TestCollection");
        collectionRepository.save(collection);

        List<Collection> found = collectionRepository.findByName("TestCollection");
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getName()).isEqualTo("TestCollection");
    }
}