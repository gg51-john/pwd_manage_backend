package com.example.pwdmanage.service;

import com.example.pwdmanage.entity.Document;
import com.example.pwdmanage.model.DocumentClient;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class DocumentManageService extends ToolService {
    public List<DocumentClient> findAllDocuments() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = firestore.collection("document").orderBy("categoryInfo").get();
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
