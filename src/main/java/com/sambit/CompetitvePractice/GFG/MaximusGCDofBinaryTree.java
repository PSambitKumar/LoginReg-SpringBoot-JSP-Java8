package com.sambit.CompetitvePractice.GFG;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 17/01/2023 - 9:57 PM
 */
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class MaximusGCDofBinaryTree {
    int maxGCD(Node root) {
        if (root == null)
            return 0;
        return maxGCDUtil(root, root.data);
    }

    int maxGCDUtil(Node root, int node_data) {
        if (root == null)
            return node_data;
        node_data = gcd(node_data, root.data);
        int res = maxGCDUtil(root.left, node_data);
        res = maxGCDUtil(root.right, node_data);
        return res;
    }

    int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}

