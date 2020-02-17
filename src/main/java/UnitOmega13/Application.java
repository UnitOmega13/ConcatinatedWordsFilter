package src.main.java.UnitOmega13;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> result = Filter.findAllConcatenatedWords();
        System.out.println("Longest concatenated word is " + result.get(0) + ", second word is " + result.get(1));
    }

    public static class Filter {

        static HashSet<String> allWords = new HashSet<>();
        static List<String> concatenatedWords = new ArrayList<>();
        static List<String> lines = new ArrayList<>();

        public static List<String> findAllConcatenatedWords() throws FileNotFoundException {
            Scanner scanner = new Scanner(new File( "words.txt"));
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

        private static boolean findConcatenatedStrings(String string, int startPosition, int n){
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
}
