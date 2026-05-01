import java.util.Stack;

class Solution {
    private boolean check(char start, char end) {
        if (start == '(' && end == ')') return true;
        if (start == '{' && end == '}') return true;
        if (start == '[' && end == ']') return true;
        return false;
    }

    private boolean isClose(char s) {
        return (s == ')' || s == ']' || s == '}');
    }

    public boolean isValid(String str) {
        if (str == null || str.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char t = str.charAt(i);
            if (isClose(t)) {
                if (stack.isEmpty()) return false;
                if (!check(stack.peek(), t)) return false;
                else stack.pop();
            } else {
                stack.push(t);
            }
        }

        return stack.isEmpty();
    }
}
