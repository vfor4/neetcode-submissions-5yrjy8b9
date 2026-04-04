class Solution {

    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for (var str : strs) {
            sb.append(String.format("%03d", str.length())).append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        var result = new ArrayList<String>();
        var chars = str.toCharArray();
        for(int i = 0; i < chars.length;) {
            var strLen = String.valueOf(chars, i, 3);
            var len = Integer.valueOf(strLen);
            i = i + 3;
            result.add(str.substring(i, i + len));
            i = i + len;
        }
        return result;
    }
}
