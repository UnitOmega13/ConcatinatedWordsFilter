import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class FilterTest {
    static final List<String> concatenatedWords = new ArrayList<>();
    static final String[] list = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
    static final HashSet<String> words = new HashSet<>(Arrays.asList(list));
    static MyComparator myComparator;

    public static void main(String[] args) {
        findAllConcatenatedWords();
    }

    @Test
    static void findAllConcatenatedWords() {
        for (String word : words.toArray(new String[0])) {
            if(findConcatenatedStrings(word, 0, 0)) {
                concatenatedWords.add(word);
            }
        }
        concatenatedWords.sort(myComparator);
        System.out.println(concatenatedWords);
    }

    private static boolean findConcatenatedStrings(String string, int startPosition, int n){
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