class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var m = new HashMap<String, List<String>>();
        for (var str : strs) {
            var key = sort(str);
            if (m.containsKey(key)) {
                var value = m.get(key);
                value.add(str);
                m.put(key, value);
            } else {
                var value = new ArrayList<String>();
                value.add(str);
                m.put(key, value);
            }
        }
        return m.values().stream().toList();
    }

    public String sort(final String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
