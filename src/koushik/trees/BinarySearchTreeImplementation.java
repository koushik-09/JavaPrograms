package koushik.trees;

public class BinarySearchTreeImplementation {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
//        bst.insert(15);
//        bst.insert(10);
//        bst.insert(20);
//        bst.insert(4);
//        bst.insert(2);
        bst.insert(new int[]{60,25,15,30,75,65,85,5});
        bst.display();
//        System.out.println( bst.getHeight());
//        bst.levelOrder();
//        System.out.println(bst.isBalanced());
//        bst.inOrder();
//        System.out.println();
//        bst.preOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
//        bst.levelOrder();
//        System.out.println(bst.search(12));
        bst.delete(25);
        bst.preOrder();
    }
}
