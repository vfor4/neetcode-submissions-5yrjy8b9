class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var m = new HashMap<Integer, Integer>();
        for (var num : nums) {
            m.merge(num, 1, Integer::sum);
        }

        ArrayList<Integer> freeList = new ArrayList(m.keySet());
        freeList.sort((o1, o2) -> m.get(o2) - m.get(o1));

        var result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = freeList.get(i);
        }

        return result;
    }
}
