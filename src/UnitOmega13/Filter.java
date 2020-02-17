package UnitOmega13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Filter {

    HashSet<String> allWords = new HashSet<>();
    List<String> concatenatedWords = new ArrayList<>();
    List<String> lines = new ArrayList<>();

    public List<String> findAllConcatenatedWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("words.txt"));
        while (scanner.hasNext()) {
            lines.add(scanner.next());
        }
        allWords.addAll(Arrays.asList(lines.toArray(new String[0])));
        for (String word : lines.toArray(new String[0])) {
            if (findConcatenatedStrings(word, 0, 0)) {
                concatenatedWords.add(word);
            }
        }
        concatenatedWords.sort(Comparator.comparingInt(s -> Math.abs(s.length() - "intelligent".length())));
        return concatenatedWords;
    }

    private boolean findConcatenatedStrings(String string, int startPosition, int n){
        if(startPosition == string.length() && n > 1){
            return true;
        }
        for(int i = startPosition + 1; i <= string.length(); i++){
            if(allWords.contains(string.substring(startPosition, i))) {
                if(findConcatenatedStrings(string, i, n++)) return true;
            }
        }
        return false;
    }
}
