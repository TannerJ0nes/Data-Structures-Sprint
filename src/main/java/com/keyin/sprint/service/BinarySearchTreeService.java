package com.keyin.sprint.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.sprint.entity.TreeData;
import com.keyin.sprint.repository.TreeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinarySearchTreeService {

    private final TreeDataRepository treeDataRepository;

    @Autowired
    public BinarySearchTreeService(TreeDataRepository treeDataRepository) {
        this.treeDataRepository = treeDataRepository;
    }

    // Helper method to insert a new node in BST
    private BSTNode insertRec(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            return root;
        }
        if (value < root.getValue())
            root.setLeft(insertRec(root.getLeft(), value));
        else if (value > root.getValue())
            root.setRight(insertRec(root.getRight(), value));

        return root;
    }

    // Converts array of numbers into a BST and returns the root
    public BSTNode createBST(int[] numbers) {
        BSTNode root = null;
        for (int number : numbers) {
            root = insertRec(root, number);
        }
        return root;
    }

    // Converts BST to JSON string
    public String bstToJson(BSTNode root) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(root);
    }

    // Processes input numbers and creates and saves tree data
    public String processAndSaveTree(String inputNumbers) throws JsonProcessingException {
        // Split the input string into an array of strings, then convert to int array
        String[] numberStrings = inputNumbers.split(",");
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            try {
                numbers[i] = Integer.parseInt(numberStrings[i].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: " + numberStrings[i] + " is not a valid number.");
            }
        }

        BSTNode root = createBST(numbers);
        String json = bstToJson(root);

        TreeData treeData = new TreeData(inputNumbers, json);
        treeDataRepository.save(treeData);

        return json;
    }
}
