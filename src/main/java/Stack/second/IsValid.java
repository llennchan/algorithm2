package Stack.second;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author 包成
 */
public class IsValid {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for (char character : s.toCharArray()) {
            Character c = map.get(character);
            if (c != null) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != c) return false;
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

}
