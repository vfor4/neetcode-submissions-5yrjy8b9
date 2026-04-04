class Solution {
    public int[] twoSum(int[] numbers, int target) {
                int left = 0, right = numbers.length;
        while(true) {
            var su = numbers[left] + numbers[right - 1];
            if (su > target) {
                right--;
            } else if (su < target) {
                left++;
            } else {
                return new int[]{left+1, right};
            }
        }
    }
}
