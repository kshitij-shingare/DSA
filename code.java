|Implement a Binary Tree with insert (), delete (), and in order() traversal.|

public class SimpleBST {
    static class Node {
        int key;
        Node left, right;
        Node(int k) { key = k; }
    }

    private Node root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insertRec(node.left, key);
        else if (key > node.key) node.right = insertRec(node.right, key);
        return node;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node node, int key) {
        if (node == null) return null;
        if (key < node.key) node.left = deleteRec(node.left, key);
        else if (key > node.key) node.right = deleteRec(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node succ = minNode(node.right);
            node.key = succ.key;
            node.right = deleteRec(node.right, succ.key);
        }
        return node;
    }

    private Node minNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node == null) return;
        inorderRec(node.left);
        System.out.print(node.key + " ");
        inorderRec(node.right);
    }

    public static void main(String[] args) {
        SimpleBST bst = new SimpleBST();
        int[] vals = {50, 30, 20, 40, 70, 60, 80};
        for (int v : vals) bst.insert(v);
        System.out.print("Initial inorder: ");
        bst.inorder();
        bst.delete(20);
        System.out.print("After deleting 20: ");
        bst.inorder();
        bst.delete(30);
        System.out.print("After deleting 30: ");
        bst.inorder();
        bst.delete(50);
        System.out.print("After deleting 50: ");
        bst.inorder();
    }
}
