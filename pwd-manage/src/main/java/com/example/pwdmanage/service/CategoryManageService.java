package com.example.pwdmanage.service;

import com.example.pwdmanage.entity.Category;
import com.example.pwdmanage.entity.Document;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CategoryManageService extends ToolService {

    public List<Category> findAllCategory() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = firestore.collection("category").get();
        List<QueryDocumentSnapshot> snapshots = future.get().getDocuments();

        List<Category> documentList = new ArrayList<>();
        for (QueryDocumentSnapshot document : snapshots) {
            documentList.add(document.toObject(Category.class));
        }
        return documentList;
    }

//    public void findCategory(Category category) {
//        Firestore firestore = FirestoreClient.getFirestore();
//        DocumentReference docRef = firestore.collection("category").whereEqualTo()
//        ApiFuture<DocumentSnapshot> future = docRef.get();
//
//        DocumentSnapshot document = future.get();
//        if (document.exists()) {
//            return document.toObject(Document.class);
//        } else {
//            throw new Exception("File Not Found");
//        }
//    }

    public void insertCategory(String categoryName) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("category").document();

        Category category = new Category();
        category.setCategory(categoryName);
        category.setCategoryId(documentReference.getId());
        ApiFuture<WriteResult> writeResult = documentReference.set(category);
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }

//    public void updateCategory(Category category) throws ExecutionException, InterruptedException {
//        Firestore firestore = FirestoreClient.getFirestore();
//        DocumentReference documentReference = firestore.collection("category").document(category.getCategoryId());
//        document.setLastUpdateDate(DateFormat());
//        ApiFuture<WriteResult> writeResult = documentReference.set(document);
//        System.out.println("Update time : " + writeResult.get().getUpdateTime());
//    }
}
