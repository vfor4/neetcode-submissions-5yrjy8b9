class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        var len = nums.length - 1;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = len;
            while (left < right) {
                var nl = nums[left];
                var nr = nums[right];
                var ni = nums[i];
                var rs = ni + nl + nr;
                if (rs == 0) {
                    result.add(List.of(ni, nl, nr));
                    do {
                        left++;
                    } while (nums[left] == nums[left - 1] && left < right);
                } else if (rs > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
