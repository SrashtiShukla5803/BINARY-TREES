public class LevelOrderTraversalBruteForceApproach {
 


/**
 * This is the Brute Force approach(Simple approach very Time complex:) )
 * we will learn other algorithms also (BFS[Breadth First Search(using Queue)] and DFS[Depth First Search(using Stack)])
 */

    static class Node{
        int data;
        Node root;
        Node left;
        Node right;

        Node(int data){
        this.data=data;
        }
    }

    public static int height(Node root)
    // To find out the levels in this Tree as (Levels=Height+1)
    {
        if(root==null || (root.left==null && root.right==null))return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    /**
     * 
     *Firstlt let's see how can we print Level order Traversal by Traversing through nth level for this we will use for loop
     */
    public static void kthLevel(Node root , int Level){
        if(root==null)return;
        if(Level ==1) System.out.print(root.data+" ");
        kthLevel(root.left,Level-1);
        kthLevel(root.right,Level-1);
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

        int level= height(root)+1 ;
        System.out.println("Number of Levels are: "+level);
        /**
         * Brute force approach of printing Level Order Traversal
         */
        System.out.println("Level order Traversal by Brute force approach: ");
        for(int i=1;i<=level;i++)
        {
            kthLevel(root, i);
            System.out.println();
        }
    }
}

