// src/test/java/com/aoi/Mastercopy/service/CollectionServiceTest.java
package com.aoi.Mastercopy.service;

import com.aoi.Mastercopy.dto.CollectionDTO;
import com.aoi.Mastercopy.model.Collection;
import com.aoi.Mastercopy.repository.CollectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CollectionServiceTest {

    private CollectionRepository collectionRepository;
    private CollectionService collectionService;

    @BeforeEach
    void setUp() {
        collectionRepository = mock(CollectionRepository.class);
        collectionService = new CollectionService();
        // Use reflection to inject the mock (since field is private and @Autowired)
        try {
            var field = CollectionService.class.getDeclaredField("collectionRepository");
            field.setAccessible(true);
            field.set(collectionService, collectionRepository);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetAllCollections() {
        Collection c1 = new Collection();
        c1.setName("A");
        Collection c2 = new Collection();
        c2.setName("B");
        when(collectionRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<Collection> result = collectionService.getAllCollections();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("A");
        verify(collectionRepository, times(1)).findAll();
    }

    @Test
    void testCreateCollection_Success() {
        CollectionDTO dto = new CollectionDTO();
        dto.setName("TestName");

        when(collectionRepository.save(any(Collection.class))).thenReturn(new Collection());

        boolean result = collectionService.createCollection(dto);

        assertThat(result).isTrue();
        ArgumentCaptor<Collection> captor = ArgumentCaptor.forClass(Collection.class);
        verify(collectionRepository).save(captor.capture());
        assertThat(captor.getValue().getName()).isEqualTo("TestName");
    }

    @Test
    void testCreateCollection_NullDTO() {
        boolean result = collectionService.createCollection(null);
        assertThat(result).isFalse();
        verify(collectionRepository, never()).save(any());
    }

    @Test
    void testCreateCollection_EmptyName() {
        CollectionDTO dto = new CollectionDTO();
        dto.setName("");
        boolean result = collectionService.createCollection(dto);
        assertThat(result).isFalse();
        verify(collectionRepository, never()).save(any());
    }

    @Test
    void testCreateCollection_Exception() {
        CollectionDTO dto = new CollectionDTO();
        dto.setName("TestName");
        when(collectionRepository.save(any(Collection.class))).thenThrow(new RuntimeException("DB error"));

        boolean result = collectionService.createCollection(dto);

        assertThat(result).isFalse();
        verify(collectionRepository).save(any(Collection.class));
    }
}