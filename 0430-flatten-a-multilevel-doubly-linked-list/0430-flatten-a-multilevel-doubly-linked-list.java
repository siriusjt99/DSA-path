/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        // Stack to put the remaining 
        // elements of the list during the time we process child lists.
        // Eg - once we encounter that 3 has a child '7', we put 4,5,6 into stack
        Stack<Node> stack = new Stack<Node>();
        
        // Maintain a temporary pointer 'result' to return head of the result list
        Node result = head;
        // To maintain the very last element of the list
        Node temp = null;
        // While iterating from start of the list, we check if a 
        // particular node has a child node. If no, make the child pointer = null, 
        // else first, push the remaining nodes into stack, then, 
        // make the child node as next node of current node (head) and then  
        while(head != null) {
            temp = head;
            if (head.child != null) {
                if (head.next != null) {
                    head.next.prev = null;              
                    stack.push(head.next);
                }
                head.next = head.child;
                head.child.prev = head;
            }
            head.child = null;
            head = head.next;
        }
        // Once we process the main list and child lists (above), we process the
        // nodes we have put in the stack.
        // As earlier we have maintained a 'temp' node to track the very last of the list, 
        // we connect the end of the child list to the first element of the list inside stack. 
        // Eg - Once we process '11' and '12'. temp = 12. then '12' --> '9' which is temp.next = rested'
        while (!stack.isEmpty()) {
            Node rested = stack.pop();
            temp.next = rested;
            rested.prev = temp;
            while(temp.next != null) {
                temp = temp.next;
            }
        }
        return result;
    }
}