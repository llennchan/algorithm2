package Bitewise.first;

import java.util.Arrays;
import java.util.List;

/**
 * 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode-solution-0t1i/
 *
 * @author 包成
 */
public class CountBits {

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        String start = "aaa:";
        String ret = list.stream().reduce(start, (s, e) -> {
            s = s + e;
            return s;
        }, (e1, e2) -> "");
        System.out.println(ret);
    }

}
