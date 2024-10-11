import org.w3c.dom.Node;

public class SizeSumMaxMinHeightProduct {
    /**
     * This program will include all the basics of the Binary Tree
     * Size of the Tree(Total number of nodes in the tree)
     * Sum(Sum of all the values in of the nodes in the Tree)
     * Max(Maximum value in the Tree)
     * Min(Minimum value in the tree)
     * Height(Edge wise(Level-1))
     * Product(Product of all the values of the nodes in the Tree)
     */

public static class Node{
    int data;
    Node root;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
    }
}

public static int size(Node root){
    if(root==null)return 0;
    return 1+size(root.left)+size(root.right);
}

public static int sum(Node root){
    if(root==null)return 0;
    return root.data+sum(root.left)+sum(root.right);
}

public static int product(Node root){
    if(root==null) return 1;
    return root.data*product(root.left)*product(root.right);
}

public static int max(Node root){
    if(root==null)return Integer.MIN_VALUE;
    return Math.max(root.data,Math.max(max(root.left),max(root.right)));
}

public static int min(Node root){
    if(root==null)return Integer.MAX_VALUE;
    return Math.min(root.data,Math.min(min(root.left),min(root.right)));
}

public static int height(Node root){
    if(root==null||(root.left==null && root.right==null))return 0;
    return 1+Math.max(height(root.left),height(root.right));
}


public static void display(Node root) {
    if(root==null)return;
    System.out.print(root.data+"->");
    if(root.left!=null)
    System.out.print(root.left.data+", ");
    else
    System.out.print("null, ");
    if(root.right!=null)
    System.out.print(root.right.data);
    else System.out.print("null");
    System.out.println();
    display(root.left);
    display(root.right);
}

    public static void main(String[] args) {
        Node root=new Node(2);
        Node a = new Node(4);
        root.left=a;
        Node b = new Node(10);
        root.right=b;
        Node c = new Node(6);
        a.left=c;
        Node d = new Node(5);
        a.right=d;
        Node e = new Node(11);
        b.right=e;
        display(root);
        System.out.println("Size of the Tree is: "+size(root));
        System.out.println("Sum of all the values in the Tree is: "+sum(root));
        System.out.println("Maximum element in the Tree is: "+max(root));
        System.out.println("Minimum element int the Tree is: "+min(root));
        System.out.println("Height of the Tree is: "+height(root));// edge wise height(level-1)
        System.out.println("Product of all the values in the Tree is: "+product(root));
    }
}
