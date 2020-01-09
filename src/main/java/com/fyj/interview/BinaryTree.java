package com.fyj.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanyongju
 * @Title: BinaryTree
 * @date 2019/12/26 11:23
 */
public class BinaryTree<E> {
    private Node<E> _root;
    // 用列表暂时保存下节点
    private List<Node<E>> nodes = new ArrayList<>();

    public void createTree(E[] array) {
        if (array.length == 0) {
            return;
        }
        for (E e : array) {
            nodes.add(new Node<>(null, null, null, e));
        }
        // 获取根节点
        if (nodes.get(0) != null) {
            _root = nodes.get(0);
        }
        // 根据二叉树的特性5来确定每个节点的左右子节点
        for (int i = 0; i < nodes.size(); i++) {
            if ((i * 2 + 1) < nodes.size() && nodes.get(i * 2 + 1) != null) {
                nodes.get(i).left = nodes.get(i * 2 + 1);
            }
            if ((i * 2 + 2) < nodes.size() && nodes.get(i * 2 + 2) != null) {
                nodes.get(i).right = nodes.get(i * 2 + 2);
            }
        }
    }

    // 节点类
    static class Node<E> {
        // 父节点暂时没有用到
        Node<E> parent;
        // 左节点
        Node<E> left;
        // 右节点
        Node<E> right;
        // 节点中存储的数据
        E data;

        Node(Node<E> parent, Node<E> left, Node<E> right, E data) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public static void main(String[] args) {
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.createTree(array);
        binaryTree.preOrder(binaryTree._root);
        System.out.println();
        binaryTree.inOrder(binaryTree._root);
        System.out.println();
        binaryTree.postOrder(binaryTree._root);
    }

    /**
     * 先序遍历，访问根节点的操作发生在遍历其左右节点之前
     *
     * @param node 某个根节点
     */
    public void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历，访问根节点的操作发生在遍历左右节点中间
     *
     * @param node 某个根节点
     */
    public void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node + " ");
        inOrder(node.right);
    }

    /**
     * 后序遍历，访问根节点的操作发生在遍历左右节点之后
     *
     * @param node 某个根节点
     */
    public void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node + " ");
    }
}
