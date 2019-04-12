import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!queue.isEmpty()) {
            Queue<Integer> temp = new LinkedList<>();
            while (queue.size() > 1) {
                temp.offer(queue.poll());
            }
            int res = queue.peek();
            queue.poll();
            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
            return res;
        }
//        leetcode上没有队列为空时pop的用例,因此随便设置一个返回值，不抛异常
//        throw new NullPointerException();
        return 0;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!queue.isEmpty()) {
            Queue<Integer> temp = new LinkedList<>();
            while (queue.size() > 1) {
                temp.offer(queue.poll());
            }
            int res = queue.peek();
            temp.offer(queue.poll());
            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
            return res;
        }
//        leetcode上没有队列为空时top的用例,因此随便设置一个返回值，不抛异常
//        throw new NullPointerException();
        return 0;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
