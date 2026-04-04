class Solution {
    public int characterReplacement(String s, int k) {
                var max = 0;
        final var chars = s.toCharArray();
        var left = 0;
        var right = 0;
        var m = new HashMap<Character, Integer>(26);
        while (right < chars.length) {
            m.merge(chars[right], 1, Integer::sum);
            if ((right - left + 1) - maxFrequent(m) > k) {
                m.computeIfPresent(chars[left], (z, v) -> v - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;

    }
        private static int maxFrequent(Map<Character, Integer> m) {
        return m.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

}
