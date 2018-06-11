package strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by supi on 6/9/18.
 */
public class IsomorphicTest {

    Isomorphic isomorphic = new Isomorphic();

    @Test
    public void isIsomorphic() {
        Assert.assertTrue(isomorphic.isIsomorphic("add", "egg"));
    }

    @Test
    public void isNotIsomorphic() {
        Assert.assertFalse(isomorphic.isIsomorphic("foo", "bar"));
    }

    private class Isomorphic {

        private boolean isIsomorphic(String s, String t) {

            HashMap<Character, Character> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {

                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                if (map.containsKey(c1)) {
                    if (map.get(c1) != c2) {
                        return false;
                    }
                } else {
                    if (map.containsKey(c2))
                        return false;
                    map.put(c1, c2);
                }
            }
            return true;
        }
    }
}
