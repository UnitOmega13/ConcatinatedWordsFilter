package UnitOmega13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Filter {

    HashSet<String> allWords = new HashSet<>();
    List<String> concatenatedWords = new ArrayList<>();
    List<String> lines = new ArrayList<>();

    public void startFilter() throws FileNotFoundException {
        List<String> result = findAllConcatenatedWords();
        result.sort(Comparator.comparingInt(s -> Math.abs(s.length() - "intelligent".length())));
        System.out.println("Longest concatenated word is " + result.get(0) + ", second word is " + result.get(1));
    }

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
        return concatenatedWords;
    }

    private boolean findConcatenatedStrings(String string, int start, int n){

        if(start == string.length() && n > 1){
            return true;
        } else if(start == string.length() && n == 1) {
            return false;
        }
        for(int i = start + 1; i <= string.length(); i++){
            if(allWords.contains(string.substring(start, i))) {
                if(findConcatenatedStrings(string, i, n++)) return true;
            }
        }
        return false;
    }
}
