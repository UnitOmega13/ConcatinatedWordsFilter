package test;

import org.junit.jupiter.api.Test;

import java.util.*;

class FilterTest {
    List<String> concatenatedWords = new ArrayList<>();
    String[] list = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
    HashSet<String> words = new HashSet<>(Arrays.asList(list));

    @Test
    void findAllConcatenatedWords() {
        for (String word : words.toArray(new String[0])) {
            if(findConcatenatedStrings(word, 0, 0)) {
                concatenatedWords.add(word);
            }
        }
        concatenatedWords.sort(Comparator.comparingInt(s -> Math.abs(s.length() - "intelligent".length())));
        System.out.println(concatenatedWords);
    }

    private boolean findConcatenatedStrings(String string, int startPosition, int n){
        if(startPosition == string.length() && n > 1){
            return true;
        }
        for(int i = startPosition + 1; i <= string.length(); i++){
            if(words.contains(string.substring(startPosition, i))) {
                if(findConcatenatedStrings(string, i, n++)) return true;
            }
        }
        return false;
    }
}