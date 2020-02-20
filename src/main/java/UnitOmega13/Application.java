import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;


public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> result = Filter.findAllConcatenatedWords();
        System.out.println("Longest concatenated word is " + result.get(0) + ", second word is " + result.get(1));
    }

    public static final class Filter {

        private static final HashSet<String> allWords = new HashSet<>();
        private static final List<String> concatenatedWords = new ArrayList<>();
        private static final List<String> lines = new ArrayList<>();
        private static final String fileName = "words.txt";
        private static MyComparator myComparator;

        public static List<String> findAllConcatenatedWords() throws FileNotFoundException {
            Scanner scanner = new Scanner(new File( fileName));
            while (scanner.hasNext()) {
                lines.add(scanner.next());
            }
            allWords.addAll(Arrays.asList(lines.toArray(new String[0])));
            for (String word : lines.toArray(new String[0])) {
                if (findConcatenatedStrings(word, 0, 0)) {
                    concatenatedWords.add(word);
                }
            }
            concatenatedWords.sort(myComparator);
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
