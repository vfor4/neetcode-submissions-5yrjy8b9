class Solution {
    public int evalRPN(String[] tokens) {
         var st = new Stack<Integer>();
        for (var token : tokens) {
            switch (token) {
                case "+" -> st.push(eval(st.pop(), st.pop(), Integer::sum));
                case "-" -> st.push(eval(st.pop(), st.pop(), (n1, n2) -> n1 - n2));
                case "*" -> st.push(eval(st.pop(), st.pop(), (n1, n2) -> n1 * n2));
                case "/" -> st.push(eval(st.pop(), st.pop(), (n1, n2) -> n1 / n2));
                default -> st.push(Integer.valueOf(token));
            }
        }
        return st.pop();
    }

    static int eval(Integer num1, Integer num2, java.util.function.ToIntBiFunction<Integer, Integer> toFunc) {
        return toFunc.applyAsInt(num2, num1);
    }
}
