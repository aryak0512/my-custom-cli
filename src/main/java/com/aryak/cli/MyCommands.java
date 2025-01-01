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

import static com.aryak.cli.utils.Util.exists;

@ShellComponent
public class MyCommands {

    static Map<String, List<String>> lists = new ConcurrentHashMap<>();

    @ShellMethod(key = "ping", value = "Ping command without arguments")
    public String ping() {
        return "pong!";
    }

    @ShellMethod(key = "date", value = "Returns current date and time")
    public Date date() {
        return new Date();
    }

    // cp "/Users/aryak/Desktop/Unix 2/Hotel.txt" "/Users/aryak/Desktop"
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

    // lpush products eggs
    // lpush products milk
    @ShellMethod(key = "lpush", value = "Left push an element to a list")
    public int leftPush(@ShellOption String listName, @ShellOption String value) {

        List<String> list;
        if ( exists.test(lists.keySet(), listName) ) {
            list = lists.get(listName);
            list.addFirst(value);
        } else {
            list = new ArrayList<>();
            list.add(value);
            lists.put(listName, list);
        }
        return list.size();
    }

    // rpop products
    @ShellMethod(key = "rpop", value = "Right pop an element from a list")
    public int rightPop(@ShellOption String listName) {

        List<String> list;
        if ( exists.test(lists.keySet(), listName) ) {
            list = lists.get(listName);
            list.removeLast();
            return list.size();
        }
        return -1;
    }

    // show products
    @ShellMethod(key = "show", value = "Display the entire list")
    public List<String> displayList(@ShellOption String listName) {
        return exists.test(lists.keySet(), listName) ? lists.get(listName) : List.of();
    }

    // llen products
    @ShellMethod(key = "llen", value = "Display the length of list")
    public int length(@ShellOption String listName) {
        return exists.test(lists.keySet(), listName) ? lists.size() : 0 ;
    }

}
