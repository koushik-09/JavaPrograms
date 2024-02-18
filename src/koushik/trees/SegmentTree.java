package koushik.trees;

public class SegmentTree {
    private class Node{
        Node left;
        Node right;
        int data;
        int startInd;
        int endInd;
         public Node(int startInd,int endInd){
             this.startInd=startInd;
             this.endInd=endInd;
        }
    }
    Node root;
    public SegmentTree(int[] arr){
        this.root=constructTree(arr,0,arr.length-1);
    }
    private Node constructTree(int[] arr,int start,int end){
        if(start==end){
            Node leaf = new Node(start,end);
            leaf.data=arr[start];
            return leaf;
        }
        Node newnode = new Node(start,end);
        int mid=(start+end)/2;
        newnode.left=constructTree(arr,start,mid);
        newnode.right=constructTree(arr,mid+1,end);
        newnode.data=newnode.left.data+newnode.right.data;
        return newnode;
    }
    public int query(int s,int e){
        return query(this.root,s,e);
    }
    private int query(Node node,int s,int e){
        if(node.startInd>=s && node.endInd<=e){
            return node.data;
        }
        else if(node.startInd>e || node.endInd<s){
            return 0;
        }
        return query(node.left,s,e)+query(node.right,s,e);
    }
    public void update(int ind,int value){
        root.data=update(root,ind,value);
    }
    private int update(Node node,int ind,int value) {
        if (node.startInd >= ind && ind <= node.endInd) {
            if (node.startInd == ind && ind == node.endInd) {
                node.data = value;
                return node.data;
            }
            int left = update(node.left, ind, value);
            int right = update(node.right, ind, value);
            node.data = left + right;
            return node.data;
        }
        return node.data;
    }
    public void display(){
        display(root);
    }
    private void display(Node node){
        if(node==null){
//            System.out.println("No nodes to display");
            return;
        }
        System.out.println(node.data+" "+ "["+node.startInd+","+node.endInd+"]");
        display(node.left);
        display(node.right);
    }
}
