package questiontwo;

/**
 * Duy Pham 30038701 Question Two You need to create a balanced binary search
 * tree for a dictionary of no less than 10 words. You must be able to search
 * the list, add and remove from the list
 */
public class Tree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            root = addRecursive(root, newNode);
        }
    }

    //adding recursive
    private Node addRecursive(Node current, Node newNode) {
        if (current == null) {
            current = newNode;
            return current;
        }//smaller goes left
        else if (newNode.getData().compareTo(current.getData()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), newNode));
            current = balanceTree(current);
        } //bigger goes right
        else if (newNode.getData().compareTo(current.getData()) > 0) {
            current.setRight(addRecursive(current.getRight(), newNode));
            current = balanceTree(current);
        }
        return current;
    }

    private Node balanceTree(Node current) {
        int bFactor = balanceFactor(current);
        //bfactor > 1 heavy right rotate left
        if (bFactor > 1) {
            if (balanceFactor(current.getLeft()) > 0) {
                current = RotateLL(current);
            } else {
                current = RotateLR(current);
            }
        } //bfactor < -1 heavy left rotate right
        else if (bFactor < -1) {
            if (balanceFactor(current.getRight()) > 0) {
                current = RotateRL(current);
            } else {
                current = RotateRR(current);
            }
        }
        return current;
    }

    private int balanceFactor(Node current) {
        int l = getHeight(current.getLeft());
        int r = getHeight(current.getRight());
        int bFactor = l - r;
        return bFactor;
    }

    //calculate bFactor by using height of l - height of right node
    //height different can only be 1 
    private int max(int l, int r) {
        return l > r ? l : r;
    }

    private int getHeight(Node current) {
        int height = 0;
        if (current != null) {
            int l = getHeight(current.getLeft());
            int r = getHeight(current.getRight());
            int m = max(l, r);
            height = m + 1;
        }
        return height;
    }

    private Node RotateRR(Node parent) {
        Node pivot = parent.getRight();
        parent.setRight(pivot.getLeft());
        pivot.setLeft(parent);
        return pivot;
    }

    private Node RotateLL(Node parent) {
        Node pivot = parent.getLeft();
        parent.setLeft(pivot.getRight());
        pivot.setRight(parent);
        return pivot;
    }

    private Node RotateLR(Node parent) {
        Node pivot = parent.getLeft();
        parent.setLeft(RotateRR(pivot));
        return RotateLL(parent);
    }

    private Node RotateRL(Node parent) {
        Node pivot = parent.getRight();
        parent.setRight(pivot);
        return RotateRR(parent);
    }

    //removing node public method
    public void delete(String target) {
        root = deleteNode(root, target);
    }
    //deleting a node
    private Node deleteNode(Node current, String target) {
        Node parent;
        if (current == null) {
            return null;
        } else {
            //left subtree
            if (target.compareTo(current.getData()) < 0) {
                current.setLeft(deleteNode(current.getLeft(), target));
                if (balanceFactor(current) == -2)//here
                {
                    if (balanceFactor(current.getRight()) <= 0) {
                        current = RotateRR(current);
                    } else {
                        current = RotateRL(current);
                    }
                }
            } //right subtree
            else if (target.compareTo(current.getData()) > 0) {
                current.setRight(deleteNode(current.getRight(), target));
                if (balanceFactor(current) == 2) {
                    if (balanceFactor(current.getLeft()) >= 0) {
                        current = RotateLL(current);
                    } else {
                        current = RotateLR(current);
                    }
                }
            } //if target is found
            else {
                if (current.getRight() != null) {
                    //delete its inorder successor
                    parent = current.getRight();
                    while (parent.getLeft() != null) {
                        parent = parent.getLeft();
                    }
                    current.setData(parent.getData());
                    current.setRight(deleteNode(current.getRight(), parent.getData()));
                    if (balanceFactor(current) == 2)//rebalancing
                    {
                        if (balanceFactor(current.getLeft()) >= 0) {
                            current = RotateLL(current);
                        } else {
                            current = RotateLR(current);
                        }
                    }
                } else {   //if current.left != null
                    return current.getLeft();
                }
            }
        }
        return current;
    }
    
    
    //public method for search
    public void find(String name) {
        findNode(name, root);
    }
    
    //searching node
    private void findNode(String name, Node current) {
        if (current != null) {
            //newNode.getData().compareTo(current.getData()) < 0
            if (name.compareTo(current.getData()) < 0) {
                if (name.equals(current.getData())) {
                    System.out.println("Found!");
                } else {
                    findNode(name, current.getLeft());
                }
            } else {
                if (name.equals(current.getData())) {
                    System.out.println("Found!");
                } else {
                    findNode(name, current.getRight());
                }
            }
        } else {
            System.out.println("Not Found!");
        }
    }
}
