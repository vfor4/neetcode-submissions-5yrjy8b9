class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var left = 0;
        var right = matrix.length - 1;
        var n = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n] >= target) {
                return search(matrix[mid], target);
            } else if (target > matrix[mid][n]) {
                left = mid + 1;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            }
        }
        return false; 
    }

     private static boolean search(final int[] nums, final int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return false;
    }
}
