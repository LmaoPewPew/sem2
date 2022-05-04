package sn.prog2.exercises.set06_Leon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter_leon {

    private int lines;
    private int words;
    private final Map<String, Integer> occurenceMap;

    public WordFrequencyCounter_leon() {
        occurenceMap = new HashMap<>();
        lines = 0;
        words = 0;
    }

    public void analyzeText_leon(File textFile) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(textFile));
            while (true) {
                String currLine = in.readLine();
                if (currLine == null) break;
                analyzeLine_leon(currLine);
            }
        } catch (IOException ex) {
            System.out.println(
                    "Error occurred while reading from "
                            + textFile.getAbsolutePath() + ":"
            );
            System.out.println(ex);
        }
    }

    private void analyzeLine_leon(String line) {
        StringTokenizer to = new StringTokenizer(line.toLowerCase(), " .?!,", false);
        lines++;
        while (to.hasMoreTokens()) {
            wordOccurence_leon(to.nextToken());
            words++;
        }
    }

    private void wordOccurence_leon(String word) {
        if (occurenceMap.containsKey(word)) {
            int frequency = occurenceMap.get(word);
            occurenceMap.put(word, frequency + 1);
        } else occurenceMap.put(word, 1);

    }

    private void printResults_leon() {
        Set<Map.Entry<String, Integer>> entrySet = occurenceMap.entrySet();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(entrySet);

        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Collections.reverse(entryList);
        int i = 0;
        System.out.printf("Line Count: %d\nWord Count: %d\n", lines, words);
        System.out.println("Frequency of occurence of each word: ");
        for (Map.Entry<String, Integer> entry : entryList) {
            if (i % 5 == 0) System.out.println();
            System.out.printf("%10s : %3d ", entry.getKey(), entry.getValue());
            i++;
        }
    }

    public static void main(String[] args) {
/*        counter.analyzeText_leon(new File(""));
        counter.printResults_leon();
  */
    }
}
