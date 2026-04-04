class Solution {
    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;
            var midv = nums[mid];
            if (target == midv) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
