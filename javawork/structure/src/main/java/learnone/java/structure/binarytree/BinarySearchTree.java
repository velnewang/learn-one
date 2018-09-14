package learnone.java.structure.binarytree;

public class BinarySearchTree {

    Node root;

    boolean insert(int i) {
        if (root == null) {
            root = new Node(i);
            return true;
        }

        Node pointer = root;
        while (true) {
            if (i < pointer.data) {
                if (pointer.left != null) {
                    pointer = pointer.left;
                } else {
                    pointer.left = new Node(i);
                    break;
                }
            } else {
                if (pointer.right != null) {
                    pointer = pointer.right;
                } else {
                    pointer.right = new Node(i);
                    break;
                }
            }
        }
        return true;
    }

    static void preOrder(Node n) {
        System.out.print(n.data + " ");
        if (n.left != null) {
            preOrder(n.left);
        }
        if (n.right != null) {
            preOrder(n.right);
        }
    }

    static void midOrder(Node n) {
        if (n.left != null) {
            preOrder(n.left);
        }
        System.out.print(n.data + " ");
        if (n.right != null) {
            preOrder(n.right);
        }
    }

}
