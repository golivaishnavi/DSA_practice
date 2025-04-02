import java.util.*;

public class BalancedParenthesesStack {
    public static boolean balancedParentheses(String s) {
        // Write your code here...
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if (st.empty())
                    return false;
                char c = st.pop();
                if (c == '(' && s.charAt(i) == ')' || c == '{' && s.charAt(i) == '}' || c == '[' && s.charAt(i) == ']')
                    continue;
                else {
                    return false;
                }
            }
        }
        if (!st.isEmpty())
            return false;
        return true;
    }
}