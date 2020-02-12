package com.codecool.filepartreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically() {
        String content = filePartReader.readLines();
        ArrayList<String> contentAsList = new ArrayList<String>(Arrays.asList(content.split("\\s+")));
        Collections.sort(contentAsList);
        return contentAsList;
    }

    public List getWordsContainingSubstring (String subString) {
        List result = new ArrayList<String>();
        String content = filePartReader.readLines();
        List<String> contentAsList = new ArrayList<String>(Arrays.asList(content.split("\\s+")));

        for (String element : contentAsList) {
            if (element.contains(subString)) {
                result.add(element);
            }
        }
        return result;
    }

    public List getStringsWhichPalindromes() {
        List result = new ArrayList<String>();
        String content = filePartReader.readLines();
        List<String> contentAsList = new ArrayList<String>(Arrays.asList(content.split("\\s+")));

        for (String element : contentAsList) {
            if (isPalindrome(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
}
