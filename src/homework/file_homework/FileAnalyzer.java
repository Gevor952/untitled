package homework.file_homework;

import java.io.*;
import java.security.Key;
import java.util.*;

public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) throws IOException {
        // Читаем файл, составляем мапу слово-количество и возвращаем ее
        File file = new File(path);
        Map<String, Integer> arr = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("!", "").replaceAll(",", "").replaceAll("\\.", "").replaceAll("\\?", "");
                String[] words = line.split(" ");
                for (String word : words) {
                    if (arr.containsKey(word)) {
                        int count = arr.get(word);
                        arr.put(word, ++count);
                    } else {
                        arr.put(word, 1);
                    }

                }
            }
        }
        return arr;
    }

    public int totalWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем общее количество слов
        Map<String, Integer> arr = wordMap(path);
        Collection<Integer> wordsCounts = arr.values();
        int sum = 0;
        for (int count : wordsCounts) {
            sum += count;
        }

        return sum;
    }

    public int uniqueWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем количество уникальных слов
        return wordMap(path).size();
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        // Читаем файл, находим топ-N часто встречающихся слов
        Map<String, Integer> wordMap = wordMap(path);
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordMap.entrySet());
        sortedEntries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        Map<String, Integer> topWords = new LinkedHashMap<>();
        if(n > wordMap.size())
        {
            throw new IllegalArgumentException("n > size");
        }
        for (int i = 0; i < n && i < sortedEntries.size(); i++) {
            Map.Entry<String, Integer> entry = sortedEntries.get(i);
            topWords.put(entry.getKey(), entry.getValue());
        }

        return topWords;
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        // Читаем файл, находим количество вхождений слова и возвращаем это число
        Map<String, Integer> arr = wordMap(path);
        if (arr.get(word) != null) {
            return arr.get(word);
        }
        return 0;
    }

}
