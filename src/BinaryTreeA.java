public class BinaryTreeA {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public void print(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + "\n ");
        print(node.left);
        print(node.right);
    }
}
