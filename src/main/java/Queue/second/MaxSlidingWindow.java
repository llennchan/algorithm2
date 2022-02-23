package Queue.second;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 包成
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) return new int[0];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.getLast()]) {
                stack.removeLast();
            }
            stack.addLast(i);
        }

        int[] ret = new int[nums.length - k + 1];
        ret[0] = nums[stack.getFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.getLast()]) {
                stack.removeLast();
            }
            stack.addLast(i);
            if (stack.getFirst() < i - k + 1) {
                stack.pop();
            }
            ret[i - k + 1] = nums[stack.getFirst()];
        }

        return ret;
    }

}
