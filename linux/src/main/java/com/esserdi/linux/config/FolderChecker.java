package com.esserdi.linux.config;

import java.io.File;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class FolderChecker {
	
	private static final String FOLDER_PATH = System.getProperty("user.home") + "/.control-pc-esserdi/";
	
    @PostConstruct
    public void init() {
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Carpeta creada: " + FOLDER_PATH);
        }
    }

}
