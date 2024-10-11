import java.util.*;

public class PrintElementsAtNthLevel {


    static class Node{
        int data;
        Node root;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    public static void nthLevel(Node root,int n)
    {
        if(root==null) return;
        if(n==1) System.out.print(root.data+" "); // Targeted level will be where n=1
        nthLevel(root.left,n-1);
        nthLevel(root.right,n-1);
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
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Level of which elements are to be printed: ");
        int k=sc.nextInt();
        nthLevel(root, k);
    }
}
