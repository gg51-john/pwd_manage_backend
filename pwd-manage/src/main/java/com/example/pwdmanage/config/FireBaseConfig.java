package com.example.pwdmanage.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FireBaseConfig {
    @PostConstruct
    public void configureFireBaseConnection() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("config/pwd-project-17e8b-firebase-adminsdk-scktb-a7618be44a.json");

        InputStream inputStream = classPathResource.getInputStream();

        File file = File.createTempFile("pwd-project-17e8b-firebase-adminsdk-scktb-a7618be44a_copy", ".json");
        try {
            FileUtils.copyInputStreamToFile(inputStream, file);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

//        File file = ResourceUtils.getFile("classpath:config/pwd-project-17e8b-firebase-adminsdk-scktb-a7618be44a.json");

        FileInputStream serviceAccount = new FileInputStream(file);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

        FirebaseApp.initializeApp(options);

    }
}
