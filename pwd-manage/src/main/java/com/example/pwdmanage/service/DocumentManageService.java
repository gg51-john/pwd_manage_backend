package com.example.pwdmanage.service;

import com.example.pwdmanage.entity.Document;
import com.example.pwdmanage.model.DocumentClient;
import com.example.pwdmanage.model.PaginationSetting;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class DocumentManageService extends ToolService {
    public List<DocumentClient> findAllDocuments(String uid) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        CollectionReference collection = firestore.collection("document");

        //因firestore只支援前後頁查詢無法跳頁，先使用全查
        Query query = collection.whereEqualTo("uid", uid)
                .orderBy("categoryInfo")
                .orderBy("createDate");

//        if (paginationSetting.getFirstPage()) {
//            query = query.limit(paginationSetting.getLimit());
//
//        } else {
//            query = query.startAfter(paginationSetting.getLastField());
//        }
        ApiFuture<QuerySnapshot> future = query.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<DocumentClient> documentClients = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            documentClients.add(document.toObject(DocumentClient.class));
        }
        return documentClients;
    }

    public Document findDocument(String id) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference docRef = firestore.collection("document").document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();
        if (document.exists()) {
            return document.toObject(Document.class);
        } else {
            throw new Exception("File Not Found");
        }
    }

    public void insertDocument(Document document) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("document").document();
        document.setId(documentReference.getId());
        document.setCreateDate(DateFormat());
        ApiFuture<WriteResult> writeResult = documentReference.set(document);
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }

    public void updateDocument(Document document) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("document").document(document.getId());
        document.setLastUpdateDate(DateFormat());
        ApiFuture<WriteResult> writeResult = documentReference.set(document);
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }

    public void deleteDocument(String id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = firestore.collection("document").document(id).delete();
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }
}
