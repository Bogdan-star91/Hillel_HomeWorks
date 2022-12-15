package com.game.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public interface Saved extends GameController {
    static void saved(String results) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String path = Paths.get("").toAbsolutePath().toString();

        try (FileWriter saver = new FileWriter(path + "\\results.txt", true)) {
            System.out.println("Save results in: " + path);
            saver.write(dtf.format(now) + " -> " + results + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
