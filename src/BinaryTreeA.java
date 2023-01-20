import java.util.ArrayList;
import java.util.Collections;

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

    public void insertBalanced(ArrayList<Integer> arrayList){
        //Collections.sort(arrayList);
        //arrayList.forEach(System.out::println);
        insertSorted(arrayList,0,arrayList.size()-1);
    }

    public void insertSorted(ArrayList<Integer> arrayList, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            insert(arrayList.get(mid));
            insertSorted(arrayList, start, mid - 1);
            insertSorted(arrayList, mid + 1, end);
        }
    }

    public void clearTree(Node root) {
        if (root == null) {
            return;
        }
        clearTree(root.left);
        clearTree(root.right);
        root.left = null;
        root.right = null;
        root = null;
    }

    public boolean contains(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.value == val) {
            return true;
        }
        if (val < root.value) {
            return contains(root.left, val);
        } else {
            return contains(root.right, val);
        }
    }
}
