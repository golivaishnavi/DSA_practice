import java.util.*;

public class BeautyOfSubstrings{
    public static int beautyOfSubstring(String s) {
        // Write your code here...
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            for (int j = i; j < n; j++) {
                arr[s.charAt(j) - 'a'] += 1;
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (int val : arr) {
                    if (val > 0) {
                        max = Math.max(max, val);
                        min = Math.min(min, val);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }

}