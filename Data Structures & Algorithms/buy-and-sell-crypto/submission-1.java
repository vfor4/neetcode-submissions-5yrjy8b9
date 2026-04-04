class Solution {
    public int maxProfit(int[] prices) {
                var result = 0;
        var left = 0;
        var right = 1;
        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
            }
            var t = prices[right] - prices[left];
            if (t > result) {
                result = t;
            }
            right++;
        }
        return result;
    }
}
