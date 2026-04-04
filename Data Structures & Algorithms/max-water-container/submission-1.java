class Solution {
    public int maxArea(int[] heights) {
                var len = heights.length;
        var left = 0;
        var right = len - 1;
        var maxArea = 0;
        while (left < right) {
            var t = (right - left) * Math.min(heights[left], heights[right]);
            if (t > maxArea) {
                maxArea = t;
            }
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
