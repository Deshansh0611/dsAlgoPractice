package stackQueue;

import java.util.Stack;

public class NextGreaterNumber {
    public static void main(String[] args) {
        int[] arr = {11, 13};
        for(int i: getNextGreaterNumbers(arr))
            System.out.println(i);
    }

    private static int[] getNextGreaterNumbers(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] output = new int[arr.length];
        stack.push(0);
        int next = 1;
        while (next < arr.length) {
            if (stack.isEmpty() || arr[next] <= arr[stack.peek()])
                stack.push(next++);
            else
                output[stack.pop()] = arr[next];
        }
        while (!stack.isEmpty())
            output[stack.pop()] = -1;
        return output;
    }
}
