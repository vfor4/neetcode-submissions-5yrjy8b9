class Solution {
    boolean isValid(String s) {
        var closeParentheses = List.of(']', '}', ')');
        if (s.length() % 2 != 0) {
            return false;
        }
        var st = new Stack<Character>();
        var chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (closeParentheses.contains(chars[i]) && isParentheses(st, chars[i])) {
                st.pop();
            } else {
                st.push(chars[i]);
            }
        }
        return st.isEmpty();
    }

    private static boolean isParentheses(final Stack<Character> st, final char c) {
        if (st.isEmpty()) {
            return false;
        }
        return st.peek() == getOpenParentheses(c);
    }

    static Character getOpenParentheses(Character c) {
        return switch (c) {
            case ']' -> '[';
            case '}' -> '{';
            case ')' -> '(';
            default -> c;
        };
    }
}
