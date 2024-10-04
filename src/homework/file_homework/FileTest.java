package homework.file_homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileTest {
    final static String FILE_PADE = "C:\\Users\\NITRO\\IdeaProjects\\untitled\\src\\homework\\file_homework\\test.text";
    static FileAnalyzer fileAnalyzer = new FileAnalyzer();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        testWordMap();
        testTotalWordCount();
        testUniquelWordCount();
        testTopFrequentWords();
        testCountWordOccurrences();
    }

    static void testWordMap() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PADE);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            Map<String, Integer> map = new HashMap<>();
            map.put("A", 1);
            oos.writeObject(map);
        }
        System.out.println(fileAnalyzer.wordMap(FILE_PADE));
    }

    static void testTotalWordCount() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PADE);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 10; i++){
                bw.write("A");
                bw.newLine();
            }
        }
        System.out.println(fileAnalyzer.totalWordCount(FILE_PADE));
    }

    static void testUniquelWordCount() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PADE);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 10; i++){
                bw.write((char)i);
                bw.newLine();
            }
        }
        System.out.println(fileAnalyzer.uniqueWordCount(FILE_PADE));
    }

    static void testTopFrequentWords() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PADE);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            Map<String, Integer> map = new HashMap<>();
            map.put("A", 1);
            map.put("B", 2);
            oos.writeObject(map);
        }
        System.out.println(fileAnalyzer.topFrequentWords(FILE_PADE, 2));
    }

    static void testCountWordOccurrences() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PADE);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 10; i++){
                bw.write("A");
                bw.newLine();
            }
        }
        System.out.println(fileAnalyzer.countWordOccurrences(FILE_PADE, "A"));
    }

}
