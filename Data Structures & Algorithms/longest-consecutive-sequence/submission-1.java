class Solution {
    public int longestConsecutive(int[] nums) {
                var max = 0;
        var result = new ArrayList<Integer>();
        for (final int num : nums) {
            var temp = new ArrayList<Integer>();
            var curr = num;
            temp.add(curr);
            for (int j = 0; j < nums.length; j++) {
                if (curr + 1 == nums[j]) {
                    temp.add(nums[j]);
                    curr = nums[j];
                    j = -1;
                }
            }
            if (temp.size() > max) {
                max = temp.size();
            }
        }
        return max;
    }
}
