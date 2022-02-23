package Stack.first;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 包成
 */
public class MyQueue {
    
    private Deque<Integer> input;
    private Deque<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (output.size() == 0) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (output.size() == 0) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

}
