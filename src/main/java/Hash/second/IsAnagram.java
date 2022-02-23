package Hash.second;

/**
 * @author 包成
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] array1 = new int[26];
        for (char cr : s.toCharArray()) {
            array1[cr - 'a']++;
        }

        for (char cr : t.toCharArray()) {
            if (--array1[cr - 'a'] < 0) return false;
        }

        return true;
    }

}
