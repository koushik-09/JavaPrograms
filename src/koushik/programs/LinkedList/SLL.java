package koushik.programs.LinkedList;

import java.util.*;

public class SLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean temp=true;
        SinglyLinkedList list = new SinglyLinkedList();
        while(temp) {
        System.out.println("1 : Insert at start");
        System.out.println("2 : Insert at last");
        System.out.println("3 : Insert at position");
        System.out.println("4 : Delete at start");
        System.out.println("5 : Delete at last");
        System.out.println("6 : Delete at position");
        System.out.println("7 : Display");
        System.out.println("8 : Size of LinkedList");
        System.out.println("9 : Exit");
        System.out.print("Choose an option: ");
            int ch=sc.nextInt();
            switch (ch){
            case 1:
                System.out.print("Enter a node value: ");
                list.insertFirst(sc.nextInt());
                break;
            case 2:
                System.out.print("Enter a node value: ");
                list.insertLast(sc.nextInt());
                break;
            case 3:
                System.out.print("Enter Position to Insert(0 indexed): ");
                int pos =sc.nextInt();
                System.out.print("Enter a node value: ");
                list.insertAtPos(sc.nextInt(),pos);
                break;
            case 4:
                list.deleteFirst();
                break;
            case 5:
                list.deleteLast();
                break;
            case 6:
                System.out.print("Enter Position to Insert(0 indexed): ");
                list.deleteAtPos(sc.nextInt());
                break;
            case 7:
                list.display();
                break;
            case 8:
                System.out.println("The size of LinkedList is "+list.getSize());
                break;
            case 9:
                System.out.println("Terminating Process...");
                temp=false;
                break;
            default:
                System.out.println("Invalid choice");
                break;
            }
        }
    }
}
