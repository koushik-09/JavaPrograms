package koushik.trees;

import java.util.Scanner;

public class BinaryTreeImplementation {
    public static void main(String[] args) {
        BinaryTree binarytree = new BinaryTree();
        binarytree.populate(new Scanner(System.in));
        binarytree.traverse();
    }
}
