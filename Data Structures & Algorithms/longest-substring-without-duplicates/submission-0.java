class Solution {
    public int lengthOfLongestSubstring(String s) {
                var l = 0;
        if (s.isEmpty()) { return 0; }
        var chars = s.toCharArray(); var right = 1; var left = 0;
        while (right < s.length()) {
            var t = left;
            while (t < right) {
                if (chars[t] == chars[right]) {
                    if (right - left > l) {
                        l = right - left;
                    }
                    left = t + 1;
                    break;
                }
               t++;
            }
            right++;
        }
        return Math.max(right - left, l);
    }
}
