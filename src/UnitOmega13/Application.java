package UnitOmega13;

import java.io.FileNotFoundException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        Filter filter = new Filter();
        List<String> result = filter.findAllConcatenatedWords();
        System.out.println("Longest concatenated word is " + result.get(0) + ", second word is " + result.get(1));
    }
}
