
import java.util.*;
public class Ass2Q5{

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> map = new HashMap<>();

        // Normalize the text
        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.trim().split("\\s+");

        // Count word frequencies
        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            boolean isStopWord = false;

            for (int j = 0; j < stopWords.length; j++) {
                if (word.equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.isEmpty()) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        // Sort words by frequency in descending order
        List<Map.Entry<String, Integer>> list =
            new ArrayList<>(map.entrySet());

        list.sort((a, b) ->
            b.getValue().compareTo(a.getValue())
        );

        // Print the result
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}