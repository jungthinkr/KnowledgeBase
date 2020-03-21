package problems;

import structures.Stack;

public class StringUtil {
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        // see if there are any ('s remaining
        while (!stack.isEmpty()) {
            if (stack.pop() == '(') return false;
        }

        return true;
    }
}
