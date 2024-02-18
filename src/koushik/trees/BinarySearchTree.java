package koushik.trees;

import java.util.*;

public class BinarySearchTree {
    private Node node;
    private Node left;
    private Node right;
    private class Node{
        int value;
        Node left;
        Node right;
        int height;
        public Node(int value){
            this.value=value;
        }
        public int getValue(){
            return value;
        }
    }
    private Node root;
    public BinarySearchTree(){

    }
    public int getHeight(){
        return getHeight(root);
    }
    private int getHeight(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("No Nodes to Display");
        }
        display(root,"Root Node: ");
    }
    private void display(Node node,String str){
        if(node==null){
            return;
        }
        System.out.println(str+node.getValue());
         display(node.left,"Left Node of "+node.getValue()+": ");
         display(node.right,"Right Node of "+node.getValue()+": ");
    }
    public void insert(int[] arr){
        for (int i : arr) {
            insert(i);
        }
    }
    public void insert(int value){
        if(isEmpty()){
            root=new Node(value);
            root.height=1;
        }
        else{
            insert(root,value);
        }
    }
    private Node insert(Node node,int value){
        if(node==null){
            return new Node(value);
        }
        else if(value<node.getValue()){
            node.left=insert(node.left,value);
        }
        else if(value>=node.getValue()){
            node.right=insert(node.right,value);
        }
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        return node;
    }
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(getHeight(node.left)-getHeight(node.right)) <=1 && isBalanced(node.left) && isBalanced(node.right);
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }
    public void levelOrder(){
        levelOrder(root);
    }
    private void levelOrder(Node node){
        if(node==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node temp=queue.remove();
            if(temp==null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                else{
                    queue.add(null);
                }
            }
            else{
                System.out.print(temp.value+" ");
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
    }
    public boolean search(int val){
        return search(root,val);
    }
    private boolean search(Node node,int val){
        if(node == null){
            return false;
        }
        if(node.value==val){
            return true;
        }
        else if(node.value>val){
            return search(node.left,val);
        }
        else if(node.value<val){
            return search(node.right,val);
        }
        return false;
    }
    public void delete(int val){
        if(!search(val)){
            System.out.println("Given Node is not present");
            return;
        }
        delete(root,null,val);
    }
    private void delete(Node node,Node prev,int val){
        if(node.value>val){
            delete(node.left,node,val);
        }
        else if(node.value<val){
            delete(node.right,node,val);
        }
        else if(node.value==val){
            if(node.left==null && node.right==null){
                if(prev.left!=null){
                    prev.left=null;
                    System.out.println("Node "+node.value+" deleted");
                }
                else{
                    prev.right=null;
                    System.out.println("Node "+node.value+" deleted");
                }
            }
            else if(node.left == null || node.right == null){
                if(prev.left!=null && prev.left.value==val){
                    if(node.left!=null){
                        prev.left=node.left;
                        System.out.println("Node "+node.value+" deleted");
                    }
                    else{
                        prev.left=node.right;
                        System.out.println("Node "+node.value+" deleted");
                    }
                }
                else if(prev.right!=null && prev.right.value==val){
                    if(node.left!=null){
                        prev.right=node.left;
                        System.out.println("Node "+node.value+" deleted");
                    }
                    else{
                        prev.right=node.right;
                        System.out.println("Node "+node.value+" deleted");
                    }
                }
            }
            else{
                Node tempNode=node.right;
                while(tempNode.left!=null){
                    tempNode=tempNode.left;
                }
                int temp=node.value;
                node.value=tempNode.value;
                tempNode.value=temp;
////                ArrayList<Node> list = new ArrayList<>();
////                inOrder(node.left,list);
//                Node tempNode=node.right;
//                int temp=0;
//                while(tempNode.left!=null){
//                    tempNode=tempNode.left;
//                    temp=tempNode.value;
//                }
////                int temp= node.value;
//                node.value=temp;
//                tempNode=node.right;
//                while(tempNode.left!=null){
//                    tempNode=tempNode.left;
//                }
//                tempNode.value=temp;
                delete(node.right,node,tempNode.value);
            }
        }
    }
    private void inOrder(Node node,ArrayList<Node> list){
        if(node==null){
            return;
        }
        inOrder(node.left,list);
        list.add(node);
        inOrder(node.right,list);
    }
}
