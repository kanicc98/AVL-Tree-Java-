
package questiontwo;

/**
 * Duy Pham 30038701
 * Question Two
 * You need to create a balanced binary search tree for a dictionary of no less
than 10 words. You must be able to search the list, add and remove from the
list
 */
public class QuestionTwo {
    public static void main(String[] args) {
        Tree newTree = new Tree();
        
        newTree.add("determine");
        newTree.add("bull");
        newTree.add("frog");
        newTree.add("adam");
        newTree.add("cloud");
        newTree.add("guts");
        newTree.add("DETERMINE");
        newTree.add("BULL");
        newTree.add("FROG");
        newTree.add("ADAM");
        newTree.add("CLOUD");
        newTree.add("GUTS");

        if (newTree.getRoot() == null)
        {
            System.out.println("Tree is empty!");
        }
        System.out.println("Root: " + newTree.getRoot().getData() + displayInOrder(newTree.getRoot()));
        
        System.out.println("\nDeleting adam node");
        newTree.delete("adam");
        if (newTree.getRoot() == null)
        {
            System.out.println("Tree is empty!");
        }
        System.out.println("Root: " + newTree.getRoot().getData() + displayInOrder(newTree.getRoot()));
        
        System.out.println("\nSearching for adam and ADAM");
        newTree.find("adam");
        newTree.find("ADAM");
    }
    
    private static String displayInOrder(Node current){
        String s = "";
        if (current != null)
        {
            s = displayInOrder(current.getLeft());
            System.out.println(current.getData());
            s += displayInOrder(current.getRight());
        }
        return s;
    }
}
