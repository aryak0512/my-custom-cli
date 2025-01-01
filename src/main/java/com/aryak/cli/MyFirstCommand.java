package com.aryak.cli;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@ShellComponent

public class MyFirstCommand {

    static Map<String, List<String>> lists = new ConcurrentHashMap<>();

    @ShellMethod(key = "ping", value = "Ping command without arguments")
    public String ping() {
        return "pong!";
    }

    @ShellMethod(key = "date", value = "Returns current date and time")
    public Date date() {
        return new Date();
    }

    // cpfile "/Users/aryak/Desktop/Unix 2/Hotel.txt" "/Users/aryak/Desktop"
    @ShellMethod(key = "cp", value = "Copies a file from one location to another on local disk")
    public void copyFile(String path1, String path2) {

        Path source = Paths.get(path1);
        var fileName = source.getFileName().toString();
        Path destination = Paths.get(path2 + "/" + fileName);

        try {
            Files.copy(source, destination);
        } catch (IOException e) {
            System.err.println("An error occurred while copying the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "lpush", value = "Left push an element to a list")
    public String leftPush(@ShellOption String listName, @ShellOption String value) {

        // check whether list exists or not
        if ( lists.containsKey(listName) ) {
            // add
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            lists.put(listName, list);
        }

        return null;
    }

}
