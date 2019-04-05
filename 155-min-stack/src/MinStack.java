/**
 * @ClassName MinStack
 * @Author Reimu747
 * @Date 2019/4/6 0:59
 * @Description
 * @Version 1.0
 **/

import java.util.ArrayList;
import java.util.List;

class MinStack {
    private List<Integer> realStack;
    private List<Integer> minValStack;

    public MinStack() {
        realStack = new ArrayList<>();
        minValStack = new ArrayList<>();
    }

    public void push(int x) {
        realStack.add(x);
        if (minValStack.size() == 0 || minValStack.get(minValStack.size() - 1) >= x) {
            minValStack.add(x);
        }
    }

    public void pop() {
        if (realStack.size() != 0) {
            int pop = realStack.remove(realStack.size() - 1);
            if (minValStack.size() != 0 && minValStack.get(minValStack.size() - 1) == pop) {
                minValStack.remove(minValStack.get(minValStack.size() - 1));
            }
        }
    }

    public int top() {
        return realStack.get(realStack.size() - 1);
    }

    public int getMin() {
        return minValStack.get(minValStack.size() - 1);
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(-0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
