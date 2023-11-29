package com.example.pwdmanage.service;

import com.example.pwdmanage.model.Category;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CategoryManageService extends ToolService {

    public List<Category> findAllCategory(String uid) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        CollectionReference collection = firestore.collection("category");
        Query query = collection.whereEqualTo("uid", uid)
                .orderBy("category");

        ApiFuture<QuerySnapshot> future = query.get();
        List<QueryDocumentSnapshot> snapshots = future.get().getDocuments();

        List<Category> documentList = new ArrayList<>();
        for (QueryDocumentSnapshot document : snapshots) {
            documentList.add(document.toObject(Category.class));
        }
        return documentList;
    }

    public void insertCategory(Category category) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("category").document();

        category.setCategoryId(documentReference.getId());
        ApiFuture<WriteResult> writeResult = documentReference.set(category);
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }
}
