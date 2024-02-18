package koushik.trees;

import java.util.*;

public class BinaryTree {
    public BinaryTree(){

    }
    private class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }
    private Node root;
    public void populate(Scanner scanner){
        System.out.println("Enter the value for root node: ");
        int val = scanner.nextInt();
        root=new Node(val);
        populate(scanner,root);
    }
    private void populate(Scanner scanner,Node node){
        System.out.println("Do you want to insert a node in the left of "+node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of node: ");
            int val=scanner.nextInt();
            node.left=new Node(val);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to insert a node in the right of "+node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of node: ");
            int val=scanner.nextInt();
            node.right=new Node(val);
            populate(scanner,node.right);
        }
    }
    public void traverse(){
        traverse(root);
    }
    private void traverse(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        traverse(node.left);
        traverse(node.right);
    }
}
