package koushik.programs.LinkedList;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        private int value;
        private Node next;
        Node(int n){
            this.value=n;
            this.next=null;
        }
        Node(int n, Node node){
            this.value=n;
            this.next=node;
        }

    }
    public void insertFirst(int n){
        Node newnnode = new Node(n);
        if(head==null) {
            head = newnnode;
            if (tail == null) {
                tail = newnnode;
            }
        }
        else {
            newnnode.next=head;
            head=newnnode;
        }
        size++;
    }
    public void insertLast(int n){
        Node newnode = new Node(n);
        if(tail==null){
            head=newnode;
            tail=newnode;
        }
        else{
            tail.next=newnode;
            tail=tail.next;
        }
        size++;
    }
    public void insertAtPos(int n,int pos){
        if(pos==0){
            insertFirst(n);
        }
        else if((pos==size) || pos>size){
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
            newnode.next=temp2;
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
            Node temp=head;
            while(temp.next!=tail){
                temp=temp.next;
            }
            tail=temp;
            tail.next=null;
            size--;

        }
    }
    public void deleteAtPos(int pos){
        if(pos==0){
            deleteFirst();
        }
        else if(pos>=(size-1)){
            deleteLast();
        }
        else{
            int t=0;
            Node prev=null;
            Node temp=head;
            while(t!=pos){
                prev=temp;
                temp=temp.next;
                t++;
            }
            temp=temp.next;
            prev.next=temp;
            size--;
        }
    }
    public void display(){
        Node temp=head;
        if(head==null){
            System.out.print("List is empty");
        }
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public int getSize

            (){
        return size;
    }
}
