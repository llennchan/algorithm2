package Queue.second;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 包成
 */
public class KthLargest {

    private Integer k;
    private Queue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

}
