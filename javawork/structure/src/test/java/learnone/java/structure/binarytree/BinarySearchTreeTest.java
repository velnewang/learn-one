package learnone.java.structure.binarytree;

import java.util.Random;

import org.junit.jupiter.api.Test;

import learnone.java.structure.binarytree.BinarySearchTree;

class BinarySearchTreeTest {

    @Test
    void testInsert() {

        int[] a = new int[15];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(9);
            System.out.print(a[i] + " ");
        }
        System.out.println();

        BinarySearchTree bst = new BinarySearchTree();
        for (int i : a) {
            bst.insert(i);
        }

        BinarySearchTree.preOrder(bst.root);
        System.out.println();
        BinarySearchTree.midOrder(bst.root);

    }

}
