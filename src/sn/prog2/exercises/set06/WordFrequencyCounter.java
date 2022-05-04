package sn.prog2.exercises.set06;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    private int lineCount = 0;
    private int wordCount = 0;
    private HashMap<String, Integer> wordMap = new HashMap<>();

    public void analyzeText(File textFile) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(textFile));

            // Iterate through each line of the file
            while (true) {
                String currLine = in.readLine();
                if (currLine == null) break;
                analyzeLine(currLine);
            }
        } catch (IOException ex) {
            System.out.println("Error occurred while reading from " + textFile.getAbsolutePath() + ":");
            System.out.println(ex);
        }
    }

    private void analyzeLine(String line) {
        StringTokenizer st = new StringTokenizer(line, " .,");

        String word = st.nextToken();
        lineCount++;
        wordCount += st.countTokens();

        if (!wordMap.containsKey(word)) wordMap.put(word, 1);
        else wordMap.replace(word, wordMap.get(word).intValue(), wordMap.get(word).intValue() + 1);
    }

    public void printResults() {
        Set<Map.Entry<String, Integer>> entrySet = wordMap.entrySet();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(entrySet);

        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Collections.reverse(entryList);
        int i = 0;
        System.out.printf("Line Count: %d\nWord Count: %d\n", lineCount, wordCount);
        System.out.println("Frequency of occurence of each word: ");
        for (Map.Entry<String, Integer> entry : entryList) {
            if (i % 5 == 0) System.out.println();
            System.out.printf("%10s : %3d ", entry.getKey(), entry.getValue());
            i++;
        }
    }

    public static void main(String[] args) {
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.analyzeText(new File("data/Song.txt"));
        counter.printResults();
    }
}