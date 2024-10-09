package homework.file_homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileTest {
    static final String FILE_PHAT = "C:\\Users\\NITRO\\Desktop\\untitled\\src\\homework\\file_homework\\test.text";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        Map<String, Integer> arr = fileAnalyzer.wordMap(FILE_PHAT);
        System.out.println(arr);
        int sum = fileAnalyzer.totalWordCount(FILE_PHAT);
        System.out.println(sum);
        sum = fileAnalyzer.uniqueWordCount(FILE_PHAT);
        System.out.println(sum);

        sum = fileAnalyzer.countWordOccurrences(FILE_PHAT, "Jav");
        System.out.println(sum);

    }

}
