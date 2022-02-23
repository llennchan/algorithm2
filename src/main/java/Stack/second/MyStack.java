package Stack.second;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 包成
 */
public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        queue1 = queue2;
        // 其实每次push结束后, 相比原先q1和q2互换, 实质上就是把q2清空
        queue2 = new LinkedList<>();
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

}
