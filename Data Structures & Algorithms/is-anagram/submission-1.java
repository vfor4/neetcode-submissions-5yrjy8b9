class Solution {
    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        var m = new HashMap<Character, Integer>();

        for (int i=0; i < s1.length(); i++){
            var c = s1.charAt(i);
            m.computeIfPresent(c, (k, v) -> v + 1);
            m.computeIfAbsent(c, k -> 1);
        }

        for (int i=0; i < s2.length(); i++){
            var c = s2.charAt(i);
            if (!m.containsKey(c) || m.get(c) == 0) {
                return false;
            } else {
                m.compute(c, (k,v) -> v - 1);
            }
        }
        return true;

    }
}
