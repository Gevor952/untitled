package homework.file_homework;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileAnalyzer {


    public Map<String, Integer> wordMap(String path) throws IOException, ClassNotFoundException {
        // Читаем файл, составляем мапу слово-количество и возвращаем ее
        File file = new File(path);
        if (file.exists()) {
            try (ObjectInputStream objectInputStreamStream = new ObjectInputStream(new FileInputStream(file))){
                Object object = objectInputStreamStream.readObject();
                if (object instanceof Map) {
                    return (Map<String, Integer>) object;
                }
            }
        }



        return null;
    }

    public int totalWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем общее количество слов
        File file = new File(path);
        if (file.exists()){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
                String line = "";
                int count = 0;
                while ((line = bufferedReader.readLine()) != null){
                    ++count;
                }
                return count;
            }
        }
        return 0;
    }

    public int uniqueWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем количество уникальных слов
        File file = new File(path);
        if (file.exists()){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
                String line = "";
                Set<String> uniqueWords = new HashSet<>();
                while ((line = bufferedReader.readLine()) != null){
                    uniqueWords.add(line);
                }
                return uniqueWords.size();
            }
        }
        return 0;
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException, ClassNotFoundException {
        // Читаем файл, находим топ-N часто встречающихся слов
        File file = new File(path);
        if (!file.exists()){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
                Object object = objectInputStream.readObject();
                if (object instanceof Map) {
                    if (((Map<String, Integer>) object).containsValue(n)){
                        return (Map<String, Integer>) object;
                    }
                }
            }
        }
        return null;
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        // Читаем файл, находим количество вхождений слова и возвращаем это число
        File file = new File(path);
        if (file.exists()){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
                String line = "";
                int count = 0;
                while ((line = bufferedReader.readLine()) != null){
                    if (line.equals(word)){
                        ++count;
                    }
                }
                return count;
            }
        }
        return 0;
    }

}
