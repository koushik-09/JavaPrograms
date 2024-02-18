package koushik.programs.LinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    private class Node {
        private int value;
        private Node prev;
        private Node next;
        Node(int n){
            this.value=n;
            this.prev=null;
            this.next=null;
        }
     }
      public void insertFirst(int n){
        Node newnode =new Node(n);
        if(head==null){
            head=newnode;
            tail=head;
        }
        else{
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
        }
        size++;
      }
      public void insertLast(int n){
        Node newnode = new Node(n);
        if(tail==null){
            tail=newnode;
            head=newnode;
        }
        else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
        size++;
      }
      public void insertAtPos(int n,int pos){
        if(pos==0){
            insertFirst(n);
        }
        else if(pos>=size){
            insertLast(n);
        }
        else{
            Node newnode = new Node(n);
            int t1=1;
            Node temp=head;
            while(t1!=pos){
                temp=temp.next;
                t1++;
            }
            Node temp2=temp.next;
            temp.next=newnode;
            newnode.prev=temp;
            newnode.next=temp2;
            temp2.prev=newnode;
            size++;
        }
      }
      public void deleteFirst(){
        if(head==null){
            System.out.println("Nothing to delete");
        }
        else if(head.next==null){
            head=null;
            size--;
        }
        else{
            head=head.next;
            head.prev=null;
            size--;
        }
      }
      public void deleteLast(){
        if(tail==null){
            System.out.println("Nothing to delete");
        }
        else if(head==tail){
            head=null;
            tail=null;
            size--;
        }
        else{
            tail=tail.prev;
            tail.next=null;
            size--;
        }
      }
      public void deleteAtPos(int pos){
        if(pos ==0){
            deleteFirst();
        }
        else if(pos>=(size-1)){
            deleteLast();
        }
        else{
            int t=0;
            Node p=null;
            Node temp=head;
            while(t!=pos){
                p=temp;
                temp=temp.next;
                t++;
            }
            temp=temp.next;
            p.next=temp;
            temp.prev=p;
            size--;
        }
      }
    public void display(){
        Node temp=head;
        if(head==null){
            System.out.print("List is empty");
        }
        else {
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
        }
        System.out.println();
    }
    public void display(int a){
        Node temp=tail;
        if(tail==null){
            System.out.println("Nothing to display");
        }
        else{
            while(temp!=null){
                System.out.print(temp.value+" ");
                temp=temp.prev;
            }
        }
        System.out.println();
    }
    public int getSize() {
        return size;
    }
}
