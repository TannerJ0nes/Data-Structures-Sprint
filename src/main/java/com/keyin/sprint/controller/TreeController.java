package com.keyin.sprint.controller;

import com.keyin.sprint.repository.TreeDataRepository;
import com.keyin.sprint.service.BinarySearchTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TreeController {

    private final BinarySearchTreeService bstService;
    private final TreeDataRepository treeDataRepository;

    @Autowired
    public TreeController(BinarySearchTreeService bstService, TreeDataRepository treeDataRepository) {
        this.bstService = bstService;
        this.treeDataRepository = treeDataRepository;
    }

    @GetMapping("/enter-numbers")
    public String showForm() {
        return "enterNumbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam("numbers") String numbers, Model model) {
        try {
            String jsonBST = bstService.processAndSaveTree(numbers);

            model.addAttribute("jsonBST", jsonBST);

            return "resultPage";
        } catch (Exception e) {

            model.addAttribute("errorMessage", "Error processing numbers: " + e.getMessage());
            return "errorPage";
        }
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        // Fetch previous trees from the database
        var trees = treeDataRepository.findAll();

        // Add the trees to the model to render them in the response
        model.addAttribute("trees", trees);

        return "previousTrees";
    }
}
