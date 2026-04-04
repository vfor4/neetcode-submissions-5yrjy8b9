class Solution {
    public int findMin(int[] nums) {
                var min = nums[0];
        var left = 1;
        var right = nums.length;
        while(left <= right) {
            var mid = left + (right - left) / 2;
            var rotatedMin = nums[nums.length - mid];
            if (rotatedMin < min) {
                min = rotatedMin;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return min;

    }
}
