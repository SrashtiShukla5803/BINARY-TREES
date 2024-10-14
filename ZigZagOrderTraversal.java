
import java.util.*;

/**
* approach :
* nthlevel() + reverse_nthLevel()
* and where i%2==0 apply reverse_nthLevel else apply nthLevel
* */

public class ZigZagOrderTraversal {

   static class Node{
       int data;
       Node root;Node left;Node right;
       Node(){

       }
       Node(int data){
       this.data=data;
       }
   }

   static void display(Node root){
    if(root==null) return;
        System.out.print(root.data+"->");
    if(root.left!=null)
        System.out.print(root.left.data+", ");
    else System.out.print("null, ");
    if(root.right!=null) System.out.print(root.right.data);
    else System.out.print("null");
    System.out.println();
    display(root.left);
    display(root.right);
}

public static int height(Node root){
       if(root==null || (root.left==null && root.right==null))return 0;
       return 1+Math.max(height(root.left),height(root.right));
}

public static void nthLevel(Node root, int level, List<Integer> list){
       if(root==null)return;
       if(level==1)list.add(root.data);
       nthLevel(root.left,level-1,list);
       nthLevel(root.right,level-1,list);
}

   public static void reverse_nthLevel(Node root, int level, List<Integer> list){
       if(root==null)return;
       if(level==1)list.add(root.data);
       reverse_nthLevel(root.right,level-1,list);
       reverse_nthLevel(root.left,level-1,list);
   }

   public static List<List<Integer>> zigZagOrder(Node root) {
       int level=1+height(root);
       List<List<Integer>> listList=new ArrayList<>();
       if(root ==null) return listList;
       for(int i=1;i<=level;i++) {
           List<Integer> list=new ArrayList<>();
           if (i % 2 == 0)
               reverse_nthLevel(root, i, list);
           else nthLevel(root, i, list);
           listList.add(list);
       }
       return listList;
   }

       public static void main(String[] args) {
       Node root=new Node(10);
       Node a=new Node(8);
       Node b=new Node(2);
       root.left=a;
       root.right=b;
       Node c=new Node(3);
       Node d=new Node(5);
       a.left=c;
       a.right=d;
       Node e=new Node(2);
       b.left=e;
       display(root);
       System.out.println("ZigZag Order Traversal is: ");
       System.out.println(zigZagOrder(root));
       }

   }



