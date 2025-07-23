package solvedClass.class4.p1991;

import java.io.*;

// 트리 순회 문제
public class Main {

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new Node((char) ('A' + i));
        }

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            char parent = inputs[0].charAt(0);
            char left = inputs[1].charAt(0);
            char right = inputs[2].charAt(0);

            if (left != '.') {
                tree[parent - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }
        preOrder(tree[0]);
        sb.append("\n");
        inOrder(tree[0]);
        sb.append("\n");
        postOrder(tree[0]);
        System.out.println(sb);
    }

    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        sb.append(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.data);
    }
}
