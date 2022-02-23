package Hash.first;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author 包成
 */
public class IsAnagram {

    public boolean doIsAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            sMap.compute(c, (k, v) -> {
                if (v == null) v = 0;
                return ++v;
            });
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tMap.compute(c, (k, v) -> {
                if (v == null) v = 0;
                return ++v;
            });
        }
        boolean res = true;
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Integer count = tMap.get(entry.getKey());
            if (count == null || count.compareTo(entry.getValue()) != 0) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.doIsAnagram("rat", "car"));
    }

}
