/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        var hm = new HashMap<Node, Node>();
        Node temp = head;
        while(temp != null) {
            var newNode = new Node(temp.val);
            hm.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            Node copy = hm.get(temp);
            copy.next = hm.get(temp.next);
            copy.random = hm.get(temp.random);
            temp = temp.next;
        }
        return hm.get(head);
    }
}
