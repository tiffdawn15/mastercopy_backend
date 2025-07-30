package com.aoi.Mastercopy.controller;

import com.aoi.Mastercopy.dto.ApiResponse;
import com.aoi.Mastercopy.dto.CollectionDTO;
import com.aoi.Mastercopy.model.Collection;
import com.aoi.Mastercopy.service.CollectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CollectionControllerTest {

    private CollectionService collectionService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        collectionService = mock(CollectionService.class);
        CollectionController controller = new CollectionController();
        // Inject mock service
        try {
            var field = CollectionController.class.getDeclaredField("collectionService");
            field.setAccessible(true);
            field.set(controller, collectionService);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllCollections() throws Exception {
        Collection c1 = new Collection();
        c1.setName("A");
        Collection c2 = new Collection();
        c2.setName("B");
        List<Collection> collections = Arrays.asList(c1, c2);

        when(collectionService.getAllCollections()).thenReturn(collections);

        mockMvc.perform(get("/api/collections"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("Collections fetched successfully"))
                .andExpect(jsonPath("$.data[0].name").value("A"))
                .andExpect(jsonPath("$.data[1].name").value("B"));

        verify(collectionService, times(1)).getAllCollections();
    }

    @Test
    void testCreateCollection() throws Exception {
        CollectionDTO dto = new CollectionDTO();
        dto.setName("TestName");

        when(collectionService.createCollection(any(CollectionDTO.class))).thenReturn(true);

        String json = "{\"name\":\"TestName\"}";

        mockMvc.perform(post("/api/collections")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(jsonPath("$.status").value(201))
                .andExpect(jsonPath("$.message").value("Collection created successfully"))
                .andExpect(jsonPath("$.data").value(true));

        ArgumentCaptor<CollectionDTO> captor = ArgumentCaptor.forClass(CollectionDTO.class);
        verify(collectionService).createCollection(captor.capture());
        assertThat(captor.getValue().getName()).isEqualTo("TestName");
    }
}