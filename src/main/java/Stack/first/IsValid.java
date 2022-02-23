package Stack.first;

import java.util.*;

/**
 * @author 包成
 */
public class IsValid {

    public static boolean doIsValid(String s) {
        if (s == null || s.equals("") || s.length() == 1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }

}
