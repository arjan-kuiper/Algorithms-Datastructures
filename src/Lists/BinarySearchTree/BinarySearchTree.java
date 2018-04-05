package Lists.BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(T value){
        // TODO
    }

    public boolean delete(T value){
        // TODO
        return true;
    }

    public boolean find(T value){
        // TODO
        return true;
    }

    public boolean isEmpty(){
        return (root == null);
    }

    public int height(){
        // TODO
        return -1;
    }

    private class Node<T extends Comparable<T>>{
        private T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value){
            this.value = value;
            left = null;
            right = null;
        }
    }

}
