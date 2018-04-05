package Lists.BinarySearchTree;

import java.util.Comparator;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;
    private Comparator<T> comparator;

    public BinarySearchTree(){
        root = null;
        comparator = null;
    }

    public void insert(T value){
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value){
        if(node == null) return new Node<T>(value);
        if(compare(value, node.value) == 0){
            return node;
        }else if(compare(value, node.value) < 0){
            node.left = insert(node.left, value);
        }else{
            node.right = insert(node.right, value);
        }
        return node;
    }

    public void delete(T value){
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> node, T value){
        if(node == null) throw new NullPointerException();
        if(compare(value, node.value) < 0){
            node.left = delete(node.left, value);
        }else if(compare(value, node.value) > 0){
            node.right = delete(node.right, value);
        }else{
            if(node.left == null) return node.right;
            else if(node.right == null) return node.left;
            else{
                while(node.right != null){
                    node = node.right;
                }
                node.left = delete(node.left, node.value);
            }
        }
        return node;
    }

    public boolean find(T value){
        return find(root, value);
    }

    private boolean find(Node<T> node, T value){
        if(node == null) return false;
        if(compare(value, node.value) == 0){
            return true;
        }else if(compare(value, node.value) < 0){
            return find(node.left, value);
        }else{
            return find(node.right, value);
        }
    }

    public int height(){
        return height(root);
    }

    private int height(Node<T> node){
        if(node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }

    private int compare(T x, T y){
        if(comparator == null) return x.compareTo(y);
        else return comparator.compare(x, y);
    }

    private class Node<T>{
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value, Node<T> left, Node<T> right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(T value){
            this(value, null, null);
        }
    }

}
