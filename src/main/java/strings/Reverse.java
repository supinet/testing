package strings;

/**
 * Created by supi on 6/9/18.
 */
public class Reverse {

    public String reverse(String phrase) {
        String[] words = phrase.split(" ");
        String result = "";
        for (int i = words.length - 1; i > -1; i--) {
                result = result + words[i] + " ";
        }
        return result.trim();
    }
}
