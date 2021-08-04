
package questiontwo;

/**
 * Duy Pham 30038701
 * Question Two
 * You need to create a balanced binary search tree for a dictionary of no less
than 10 words. You must be able to search the list, add and remove from the
list
 */

public class Node {
    private String data;
    private Node left;
    private Node right;
    
    public Node(String data)
    {
        this.data = data;
    }
    
    // @return the data
    public String getData() {
        return data;
    }

    // @param data the data to set
    public void setData(String data) {
        this.data = data;
    }

     // @return the left
    public Node getLeft() {
        return left;
    }

    // @param left the left to set
    public void setLeft(Node left) {
        this.left = left;
    }

    // @return the right
    public Node getRight() {
        return right;
    }

    // @param right the right to set
    public void setRight(Node right) {
        this.right = right;
    }
}
