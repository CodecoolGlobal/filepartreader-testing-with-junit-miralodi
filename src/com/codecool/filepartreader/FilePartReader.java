package com.codecool.filepartreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilePartReader {
    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader() {
        this.filePath = "...";
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {

        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("toLine must be greater than fromLine!");
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)), "UTF-8");
        return content;
    }

    public String readLines() {
        try {
            String content = read();
            String[] contentAsList = content.split("\n");
            String[] partLines = Arrays.copyOfRange(contentAsList, fromLine - 1, toLine);
            String result = String.join("\n", partLines);
            return result;
        } catch (IOException e) {
            return "File not found!";
        }
    }
}
