package com.keyin.sprint.entity;

import jakarta.persistence.*;

@Entity
public class TreeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String inputNumbers; // CSV format of user-entered numbers

    @Column(length = 10000)
    private String treeStructure;

    public TreeData() {
    }

    // Constructors, Getters, and Setters

    public TreeData(String inputNumbers, String treeStructure) {
        this.inputNumbers = inputNumbers;
        this.treeStructure = treeStructure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeStructure() {
        return treeStructure;
    }

    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }
}
