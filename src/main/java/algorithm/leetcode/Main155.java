package algorithm.leetcode;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @date 2020/5/12 10:08 上午
 */
public class Main155 {


    static class MinStack {
        private static final int MAX_SIZE = 1000;
        int[] stack;
        int top;
        int[] help;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new int[MAX_SIZE];
            help = new int[MAX_SIZE];
        }

        public void push(int x) {
            stack[top++] = x;
            if (top == 1) help[top - 1] = x;
            else help[top - 1] = Math.min(x, help[top - 2]);
        }

        public void pop() {
            top--;
        }

        public int top() {
            return stack[top - 1];
        }

        public int getMin() {
            return help[top - 1];
        }
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(0);
        obj.push(2);
        obj.push(1);
        obj.push(4);
        obj.pop();
        System.out.println(obj.getMin());
    }
}
