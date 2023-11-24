package com.example.pwdmanage.service;

import com.example.pwdmanage.entity.ThirdPartyUser;
import com.example.pwdmanage.model.ThirdPartyLoginRequest;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ThirdPartyUserService {
    @Autowired
    TokenService tokenService;
    Firestore firestore = FirestoreClient.getFirestore();

    public ThirdPartyUser find(String email) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = firestore.collection("thirdPartyUser")
                .whereEqualTo("thirdPartyUserEmail", email).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        if(!documents.isEmpty()){
            return documents.get(0).toObject(ThirdPartyUser.class);
        }
        return null;
    }

    public String insert(ThirdPartyUser thirdPartyUser) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore.collection("thirdPartyUser").document();
        ApiFuture<WriteResult> writeResult = documentReference.set(thirdPartyUser);
//        System.out.println(writeResult.get().getUpdateTime());
        return writeResult.get().getUpdateTime().toString();
//        return null;
    }

    public Boolean update(ThirdPartyUser thirdPartyUser) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore.collection("thirdPartyUser")
                .document(thirdPartyUser.getId());
        ApiFuture<WriteResult> writeResult = documentReference.set(thirdPartyUser);
        return writeResult.isDone();
    }
}
