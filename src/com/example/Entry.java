package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Entry {
    private static final SecurityManager SECURITY_MANAGER = new SecurityManager(); //1

    static {
        System.setSecurityManager(SECURITY_MANAGER); //2
    }

    public static void main(String[] args) {
        Path testFile = Path.of("C:\\ioPractice\\test.txt"); //3
        readFile(testFile); //4
        writeFile(testFile); //5
        deleteFile(testFile); //6
    }

    private static void readFile(Path file) { //7
        try {
            String content = Files.readString(file);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(Path file) { //8
        try {
            Files.writeString(file, "Hello World Again!", StandardOpenOption.APPEND);
            readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFile(Path file) { //9
        try {
            Files.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}