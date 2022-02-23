package Queue.first;

import java.util.*;

/**
 * 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @author 包成
 */
public class MaxSlidingWindow {

    public int[] doMaxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || length < k) return new int[]{};

        // 维护一个大顶堆, 类型为数组, 第一个元素是nums的value, 第二个元数是nums的index
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) ->
                o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]
        );

        // 第一个窗口
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }

        // 滑动窗口最大值数组
        int[] res = new int[length - k + 1];
        res[0] = queue.peek()[0];
        int left = 1;
        for (int i = k; i < length; i++) {
            queue.offer(new int[]{nums[i], i});
            // 当前滑动窗口, 堆顶的index如果比滑动窗口的左边界还要小, 则移出队列, 直到在窗口内
            while (queue.peek()[1] < left) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
            left++;
        }
        return res;
    }

    public int[] doMaxSlidingWindowV2(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || length < k) return new int[]{};

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
        }

        int[] res = new int[length - k + 1];
        res[0] = nums[deque.peek()];
        for (int i = k; i < length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            while (deque.peek() <= i - k) {
                deque.poll();
            }
            res[i - k + 1] = nums[deque.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        Queue<Test> queue = new PriorityQueue<>((t1, t2) -> {
            if (t1.getB() && !t2.getB()) {
                return -1;
            } else if (!t1.getB() && t2.getB()) {
                return 1;
            } else if (!t1.getB()) {
                return -1;
            } else {
                return t2.getA().compareTo(t1.getA());
            }
        });

        queue.offer(new Test(10, false));
        queue.offer(new Test(5, true));
        queue.offer(new Test(6, true));
        queue.offer(new Test(4, true));

        List<Test> list = new ArrayList<>(queue);
        list.forEach(System.out::println);
    }

    static class Test {
        private Integer a;
        private Boolean b;

        @Override
        public String toString() {
            return "Test{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        public Test() {
        }

        public Test(Integer a, Boolean b) {
            this.a = a;
            this.b = b;
        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public Boolean getB() {
            return b;
        }

        public void setB(Boolean b) {
            this.b = b;
        }
    }

}
