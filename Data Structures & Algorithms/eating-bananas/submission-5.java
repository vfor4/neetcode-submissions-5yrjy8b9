class Solution {
    private static int minEatingSpeed(final int[] piles, final int h) {
        var low = 1;
        var high = Arrays.stream(piles).max().getAsInt();
        var min = high;
        while (low <= high) {
            var k = low + (high - low) / 2;
            var val = extracted(piles, k);
            if (val > h) {
                low = k + 1;
            } else if (val <= h) {
                high = k - 1;
                if (k < min) {
                    min = k;
                }
            }
        }
        return min;
    }

    private static int extracted(final int[] piles, int k) {
        var h = 0;
        for (int i = 0; i < piles.length; i++) {
            h = h + Math.ceilDiv(piles[i], k);
        }
        return h;
    }
}
