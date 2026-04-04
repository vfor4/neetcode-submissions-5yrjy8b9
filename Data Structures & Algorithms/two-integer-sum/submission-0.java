class Solution {
    public int[] twoSum(int[] nums, int target) {
        var m = new HashMap<Integer, Integer>();
        for (int i=0; i< nums.length; i++) {
            var s = target - nums[i];
            if (m.containsKey(s)) {
                return new int[]{m.get(s), i};
            } else {
                m.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
