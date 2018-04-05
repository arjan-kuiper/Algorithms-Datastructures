package Lists.BinarySearchTree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public boolean find(int id){
        Node current = root;
        while(current != null){
            if(current.data == id){
                return true;
            }else if(current.data > id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }

    public int height(){
        // TODO
        return -1;
    }

    public boolean isEmpty(){
        // TODO
        return false;
    }

    public void clear(){
        // TODO
    }

    public boolean delete(int id){
        Node parent = root;
        Node current = root;
        boolean isLChild = false;

        while(current.data != id){
            parent = current;
            if(current.data > id){
                isLChild = true;
                current = current.left;
            }else{
                isLChild = false;
                current = current.right;
            }
            if(current == null){
                return false;
            }
        }

        // Node was found
        if(current.left == null & current.right == null){
            if(current == root){
                root = null;
            }
            if(isLChild){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }else if(current.right == null){
            if(current == root){
                root = current.left;
            }else if(isLChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }else if(current.left == null){
            if(current == root){
                root = current.right;
            }else if(isLChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left != null && current.right != null){
            Node next = getNext(current);
            if(current == root){
                root = next;
            }else if(isLChild){
                parent.left = next;
            }else{
                parent.right = next;
            }
            next.left = current.left;
        }
        return true;
    }

    public void printTree(Node root){
        if(root != null){
            printTree(root.left);
            System.out.println(" " + root.data);
            printTree(root.right);
        }
    }

    public void insertArray(int[] ids){
        for(int id : ids){
            insert(id);
        }
    }

    public void insert(int id){
        Node newNode = new Node(id);
        if(root == null){
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(id < current.data){
                current = current.left;
                if(current == null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current == null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    private Node getNext(Node node){
        Node next = null;
        Node nextParent = null;
        Node current = node.right;
        while(current != null){
            nextParent = next;
            next = current;
            current = current.left;
        }
        if(next != node.right){
            nextParent.left = next.right;
            next.right = node.right;
        }
        return next;
    }

    public Node getRootNode() { return this.root; }

}
