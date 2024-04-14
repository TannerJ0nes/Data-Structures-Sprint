package com.keyin.sprint;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keyin.sprint.repository.TreeDataRepository;
import com.keyin.sprint.service.BinarySearchTreeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BinarySearchTreeServiceTest {

    @Mock
    private TreeDataRepository treeDataRepository;

    @InjectMocks
    private BinarySearchTreeService binarySearchTreeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processAndSaveTree_ShouldReturnValidJson_WhenGivenValidNumbers() throws JsonProcessingException {
        // Arrange
        String numbers = "5,3,2,4,7,6,8";
        when(treeDataRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        // Act
        String jsonResult = binarySearchTreeService.processAndSaveTree(numbers);

        // Assert
        assertNotNull(jsonResult);
        assertTrue(jsonResult.contains("\"value\":5")); // Basic check to confirm JSON structure
        // Further assertions can be made to validate the JSON structure
    }
}

