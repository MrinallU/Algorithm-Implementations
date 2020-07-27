import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main{

    static void printInorder(Node node) 
{ 
    if (node == null) 
        return; 
  
    /* first recur on left child */
    printInorder(node.left); 
  
    /* then print the data of node */
    System.out.println(node.data + " "); 
  
    /* now recur on right child */
    printInorder(node.right); 
} 
     public static void startPrint (Node root){
       printTree(root); 
    }
    
    private static void printTree(Node root) {
      Scanner sc = new Scanner(System.in); 
        if(root == null) {
            System.out.println("null");
          
        }else{
          System.out.println("Current Node: " + root.data);
        }
        System.out.println("1 to go left and 2 to go right"); 
        int N = sc.nextInt(); 
        if(N == 1){
       System.out.println("Left root of " + root.data + ": " );
        printTree(root.left);
        }else{ 
        
          System.out.println("Right root of " + root.data + ": " );
        printTree(root.right); 
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number of Nodes: ");
        int t = scan.nextInt();  
        Node root = null;
        
        while(t-- > 0) {
          System.out.println("Enter the node: ");
          int data = scan.nextInt();

            root = insert(root, data);
        }
        System.out.println();
        printInorder(root); 
        scan.close();
        
    }	
}