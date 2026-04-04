class Solution {

    class Temp {
    int val;
    int result;
    int idx;
    public Temp(int val, int result, int idx) {
        this.val = val;
        this.result = result;
        this.idx = idx;
    }
}
    public int[] dailyTemperatures(int[] temperatures) {
          var result = new int[temperatures.length];
        var st = new Stack<Temp>();
        for (int i = 0; i < temperatures.length; i++) {
            var temp = temperatures[i];
            if (st.isEmpty()) {
                st.push(new Temp(temp, 1, i));
            } else {
                if (temp <= st.peek().val) {
                    st.push(new Temp(temp, 1, i));
                } else {
                    do {
                        var p = st.pop();
                        result[p.idx] = p.result;
                        if (!st.isEmpty()) {
                            st.peek().result = st.peek().result + p.result;
                        }
                    } while(!st.isEmpty() && temp > st.peek().val);
                    st.push(new Temp(temp, 1, i));
                }
            }
        }
        return result;
    }
}
