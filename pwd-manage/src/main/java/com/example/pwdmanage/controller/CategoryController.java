package com.example.pwdmanage.controller;

import com.example.pwdmanage.model.Category;
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
    @RequestMapping("/category/all/{uid}")
    public List<Category> findAllCategory(@PathVariable String uid) throws ExecutionException, InterruptedException {
        return categoryManageService.findAllCategory(uid);
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping
    @RequestMapping("/category/insert")
    public void insertDocument(@RequestBody Category category) throws ExecutionException, InterruptedException {
        categoryManageService.insertCategory(category);
    }
}
