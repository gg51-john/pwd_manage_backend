package com.example.pwdmanage.controller;

import com.example.pwdmanage.model.Document;
import com.example.pwdmanage.model.DocumentClient;
import com.example.pwdmanage.service.DocumentManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class DocumentController {

    @Autowired
    DocumentManageService documentManageService;

    @CrossOrigin("http://localhost:3000")
    @GetMapping
    @RequestMapping("/document/all/{uid}")
    public List<DocumentClient> findAll(@PathVariable String uid)
            throws ExecutionException, InterruptedException {
        return documentManageService.findAllDocuments(uid);
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping
    @RequestMapping("/document/{id}")
    public Document findById(@PathVariable String id) throws Exception {
        return documentManageService.findDocument(id);
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping
    @RequestMapping("/document/insert")
    public void insert(@RequestBody Document document) throws ExecutionException, InterruptedException {
        documentManageService.insertDocument(document);
//        return ResponseEntity.ok();
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping
    @RequestMapping("/document/update")
    public void update(@RequestBody Document document) throws ExecutionException, InterruptedException {
        documentManageService.updateDocument(document);
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping
    @RequestMapping("/document/delete/{id}")
    public void delete(@PathVariable String id) throws ExecutionException, InterruptedException {
        documentManageService.deleteDocument(id);
//        return ResponseEntity.ok();
    }
}
