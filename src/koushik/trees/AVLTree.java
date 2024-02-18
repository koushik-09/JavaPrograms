package koushik.trees;

public class AVLTree {
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
    public AVLTree(){

    }
    public int getHeight(Node node){
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
            root = insert(root,value);
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
        return rotate(node);
    }
    private Node rotate(Node node){
        if(getHeight(node.left)-getHeight(node.right)>1){
            //left heavy
            if(getHeight(node.left.left)-getHeight(node.left.right)>0){
                //left-left rotation
                return rightRotate(node);
            }
            if(getHeight(node.left.left)-getHeight(node.left.right)<0){
                //left-right rotation
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(getHeight(node.left)-getHeight(node.right)<-1){
            //right heavy
            if(getHeight(node.right.left)-getHeight(node.right.right)<0){
                //right-right rotation
                return leftRotate(node);
            }
            if(getHeight(node.right.left)-getHeight(node.right.right)>0){
                //right-left rotation
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p) {
        Node c=p.left;
        Node t=c.right;
        c.right=p;
        p.left=t;
        p.height=Math.max(getHeight(p.left),getHeight(p.right))+1;
        c.height=Math.max(getHeight(c.left),getHeight(c.right))+1;
        return c;
    }

    private Node leftRotate(Node c) {
        Node p=c.right;
        Node t=p.left;
        p.left=c;
        c.right=t;
        p.height=Math.max(getHeight(p.left),getHeight(p.right))+1;
        c.height=Math.max(getHeight(c.left),getHeight(c.right))+1;
        return p;
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
    public int getRoot(){
        return root.getValue();
    }
}
