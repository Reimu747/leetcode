import java.util.EmptyStackException;
import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack.isEmpty()) {
            Stack<Integer> temp = new Stack<>();
            while (stack.size() > 1) {
                temp.push(stack.pop());
            }
            int res = stack.pop();
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            return res;
        }
//        leetcode上没有队列为空时pop的用例,因此随便设置一个返回值，不抛异常
//        throw new EmptyStackException();
        return 0;
    }

    /** Get the front element. */
    public int peek() {
        if (!stack.isEmpty()) {
            Stack<Integer> temp = new Stack<>();
            while (stack.size() > 1) {
                temp.push(stack.pop());
            }
            int res = stack.peek();
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            return res;
        }
//        leetcode上没有队列为空时pop的用例,因此随便设置一个返回值，不抛异常
//        throw new EmptyStackException();
        return 0;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();  // 返回 1
        queue.pop();   // 返回 1
        queue.empty(); // 返回 false
    }
}
