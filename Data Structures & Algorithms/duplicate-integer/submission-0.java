class Solution {
    public boolean hasDuplicate(int[] nums) {
        var m = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(m.containsKey(nums[i])) {
                return true;
            }
            m.put(nums[i], 1);
        }
        return false;
    }
}
