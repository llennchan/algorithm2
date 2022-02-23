package Queue.first;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 包成
 */
public class KthLargest {

    private Queue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int n : nums) {
            add(n);
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
