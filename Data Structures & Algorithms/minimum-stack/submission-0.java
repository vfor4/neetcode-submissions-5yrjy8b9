class MinStack {

     Node top;
        int len;
        private class Node {
            Node next;
            int val;
            int min;

            Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        public MinStack() {
            this.len = 0;
        }

        public void push(int val) {
            if (this.len == 0) {
                this.top = new Node(val, val);
                this.len = 1;
            } else {
                var n = this.top;
                this.top = new Node(val, Math.min(n.min, val));
                this.top.next = n;
                this.len++;
            }
        }

        public void pop() {
            if (this.len != 0) {
                this.top = this.top.next;
                this.len--;
            }
        }

        public int top() {
            if (this.len != 0) {
                return top.val;
            }
            return 0;
        }

        public int getMin() {
            return this.top.min;
        }
}
