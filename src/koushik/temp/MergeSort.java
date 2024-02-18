package koushik.temp;

public class MergeSort {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String args[]){
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
        display(head);
        head = mergeSort(head);
        display(head);
    }


    static Node mergeSort(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node mid = findMiddle(head);
        Node nextToMid = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMid);
        Node res = mergeSorted(left, right);
        return res;
    }
    static Node findMiddle(Node head){
        if (head == null)
            return head;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    static Node mergeSorted(Node left, Node right){
        if (left == null)
            return right;
        if (right == null)
            return left;
        Node result = null;
        if (left.val <= right.val){
            result = left;
            result.next = mergeSorted(left.next, right);

        }
        else {
            result = right;
            result.next = mergeSorted(left, right.next);

        }
        return result;
    }
    static void display(Node head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
