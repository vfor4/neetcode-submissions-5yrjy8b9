class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
                int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        System.out.println(Arrays.deepToString(cars));
        var times = new double[position.length];
        for (int i = 0; i < position.length; i++) {
            times[i] = (double) (target - cars[i][0]) / cars[i][1];
        }
        System.out.println(Arrays.toString(times));
        var fleet = new Stack<Integer>();
        fleet.push(0);
        for (int i = 1; i < position.length; i++) {
            var top = fleet.peek();
            if (times[i] > times[top]) {
                fleet.push(i);
            }
        }
        return fleet.size();
    }
}
