package algorithm.leetcode.bytedance.datestructure;


import java.util.Stack;

/**
 * 最小栈
 * @author lihaoyu
 * @date 2020/8/31 12:17 AM
 */
public class MinStack {
    Stack<Integer> stack, temp;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if(temp.isEmpty() || x <= temp.peek()) temp.add(x);
        else temp.add(temp.peek());
    }

    public void pop() {
        stack.pop();
        temp.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return temp.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */