class Solution {
    public int[] productExceptSelf(int[] nums) {
        var len = nums.length;
        var result = new int[len];
        var pre = 1;
        for (int i =0 ; i < len; i ++) {
            result[i]=pre;
            pre = pre * nums[i];
        }
        var suf = 1;
        for (int i = len-1; i >= 0; i--){
            result[i] = result[i] * suf;
            suf = suf * nums[i];
        }

        return result;
    }
}  
