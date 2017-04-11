package lab7c202;
/**
 * Client Class used to test the BinarySearchTree class
 * @author Evan Cripe
 */
public class TestBinarySearchTree {
    
    public static void main(String[] args) {
        //random elements waiting to be loaded into a BST
        Integer[] num1 = {67, 87, 55, 43, 48, 73, 91, 39, 59, 92, 34, 95, 81, 66, 40, 53, 84, 77};
        Integer[] num2 = {44, 63, 9, 21, 70, 45, 9, 19, 20, 79, 19, 16, 79, 15, 66, 32, 47, 62, 8};
        Integer[] num3 = {67, 87, 55, 43, 48, 73, 91, 39, 59, 92, 34, 95, 81, 66, 40, 53, 84, 77};//copy of num1
        
        //Loading elements from the above Integer arrays num1, num2, num3 into BSTs
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>(num1);
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<>(num2);
        BinarySearchTree<Integer> tree3 = new BinarySearchTree<>(num3);//Copy of elements in tree1
        
        System.out.println("================ Search Method ================");
        System.out.println("91 is in tree1: " + tree1.search(91));
        System.out.println("1000 is in tree1: " + tree1.search(1000));
        
        System.out.println("\n\n================ Insert Method ================");
        System.out.println("38 was inserted into tree2: " + tree2.insert(38));
        System.out.println("43 was inserted into tree2: " + tree2.insert(16));
        
        System.out.println("\n\n================= Delete Method ===============");
        System.out.println("66 was deleted from tree2: " + tree2.delete(66));
        System.out.println("10 was deleted from tree2: " + tree2.delete(10));
        
        System.out.println("\n\n========= (Pre/In/Post)order Methods ==========");
        System.out.println("Preorder Tree1: ");
        tree1.preorder();
        System.out.println("\nInorder Tree1: ");
        tree1.inorder();
        System.out.println("\nPostorder Tree1: ");
        tree1.postorder();
        
        System.out.println("\n\n\n================== Path Method ================");
        System.out.println("Path to 2: " + tree1.path(2));
        System.out.println("Path to 53: " + tree1.path(53));
        
        System.out.println("\n\n========== (Left/Right)SubTree Methods ==========");
        System.out.println("LeftSubTree: " + tree1.leftSubTree());
        System.out.println("RightSubTree: " + tree1.rightSubTree());
        
        System.out.println("\n\n================ SameTree Method ================");
        System.out.println("Tree1 is the same as Tree3: " + tree1.sameTree(tree3));
        System.out.println("Tree2 is the same as Tree1: " + tree2.sameTree(tree1)); 
    }//main
}//class
