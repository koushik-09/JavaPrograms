package koushik.temp;
import koushik.temp.MergeSort.Node;
public class ReverseList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next = new Node(5);
        Node temp = head;
        display(head);
        reverseList(head);
        display(temp);
    }
    public static void reverseList(Node head){
        if(head==null){
            return;
        }
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        while(head.next!=null){
            int t=head.val;
            head.val=tail.val;
            Node temp=head.next;
            while(temp!=null){
                int t3=temp.val;
                temp.val=t;
                t=t3;
                temp=temp.next;
            }
            head=head.next;
        }
    }
    static void display(Node head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
