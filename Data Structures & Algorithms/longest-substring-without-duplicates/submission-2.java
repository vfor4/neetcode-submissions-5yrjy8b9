class Solution {
    public int lengthOfLongestSubstring(String s) {
var max = 0; var sub = new HashMap<Character, Integer>();
        var chars = s.toCharArray();
        var right = 0;
        var left = 0;
        while (right < s.length()) {
            if (sub.containsKey(chars[right])) {
                left = Math.max(sub.get(chars[right]) + 1, left);
            } 
            sub.put(chars[right], right);
            right++;
            max = Math.max(right - left, max);
        }

        return max;

    }
}
