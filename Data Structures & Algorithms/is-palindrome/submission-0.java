class Solution {
    public boolean isPalindrome(String s) {
        var sConvert = s.toLowerCase().replaceAll("[\\W_]", "");
        var len = sConvert.length();
        var half = len / 2;
        for (int i = 0; i < half; i++) {
            if (sConvert.charAt(i) != sConvert.charAt(len-1-i)) {
                return false;
            }
        }
        return true;


    }
}
