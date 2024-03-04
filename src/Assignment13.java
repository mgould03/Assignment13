import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Assignment13 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        try {
            Map<String, Integer> wordCountMap = countWords(inputFile);
            writeWordCountToFile(wordCountMap, outputFile);
            System.out.println("Word count written to output file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    public static Map<String, Integer> countWords(String inputFile) throws IOException {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.toLowerCase(); // Convert to lowercase for case-insensitive comparison
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordCountMap;
    }
    public static void writeWordCountToFile(Map<String, Integer> wordCountMap, String outputFile) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue());
                bw.newLine();
            }
        }
    }
}

