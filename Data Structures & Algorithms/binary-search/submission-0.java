class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int midval = low + (high - low) / 2;
            if (nums[midval] == target) {
                return midval;
            } else if (nums[midval] < target) {
                low = midval + 1;
            } else if (nums[midval] > target) {
                high = midval - 1;
            }
        }
        return -1;
    }
}
