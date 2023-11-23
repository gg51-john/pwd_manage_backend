package com.example.pwdmanage.controller;

import com.example.pwdmanage.entity.Category;
import com.example.pwdmanage.entity.Document;
import com.example.pwdmanage.service.CategoryManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryManageService categoryManageService;

    @CrossOrigin("http://localhost:3000")
    @GetMapping
    @RequestMapping("/category/all")
    public List<Category> findAllCategory() throws ExecutionException, InterruptedException {
        return categoryManageService.findAllCategory();
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping
    @RequestMapping("/category/insert/{categoryName}")
    public void insertDocument(@PathVariable String categoryName) throws ExecutionException, InterruptedException {
        categoryManageService.insertCategory(categoryName);
    }
}
