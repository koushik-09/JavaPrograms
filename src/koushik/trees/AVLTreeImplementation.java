package koushik.trees;

public class AVLTreeImplementation {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        for(int i=1;i<=6;i++){
            avl.insert(i);
        }
        System.out.println(avl.getRoot());
        avl.display();
        avl.preOrder();
        avl.postOrder();
        avl.inOrder();
    }
}

