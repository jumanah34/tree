package tree;

import java.util.Scanner;

    class Node{
    int data;
    Node left, right;
 
    Node(int key)
    { data = key;
      left = right = null;  }
}

public class Tree {
    
    public static Node insert(Node root, int key)
    {
        if (root == null) 
           { return new Node(key);  }

        if (key < root.data) 
           { root.left = insert(root.left, key);  }
      
        else {
            root.right = insert(root.right, key); }
       
        return root;
    }
    
    
    
     public static void inorder(Node root)
    {
        if (root == null) {return; }
       
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
     
    public static Node min(Node mi)
    {
        while (mi.left != null) {
            mi = mi.left;
        }
        return mi;
    }
    public static Node max(Node mx)
    { while (mx.right != null) {
            mx = mx.right;  }
        return mx;
    }
    public static Node delete(Node root, int key)
       { if (root == null) {return null; }
       
       if (key < root.data) {
            root.left = delete(root.left, key);}
        
       else if (key > root.data) {
            root.right = delete(root.right, key);  }
      
        else {
        
            if (root.left == null && root.right == null)    //no children
            {return null; }
                
            else if (root.left != null && root.right != null)//two children
            {
                Node predecessor = max(root.left);
                 root.data = predecessor.data;
                root.left = delete(root.left, predecessor.data);
            }
 
            else {
                Node child = (root.left != null) ? root.left: root.right;  //one child
                root = child;
            }
        }
        return root;
    }

    public static void search(Node root, int key)
    {
        if (root == null) {return ; }
            
        Node curr = root;
 
        Node parent = null;
 
        while (curr != null && curr.data != key)
        {

            parent = curr;
            if (key < curr.data) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
 
        if (curr == null)
        {
            System.out.println("Not found");
            return;
        }
 
        if (parent == null) {
            System.out.println("The node " + key + " is root node");
        }
        else if (key < parent.data)
        {
            System.out.println("It is the left node of the node with key "+ parent.data);
        }
        else {
            System.out.println("It key is the right node of the node with key "+ parent.data);
        }
    }
        

    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
            
        Node root = null;
    
    System.out.println("Enter number of all element: ");
         int n =sc.nextInt();
         int y ,x ;
         System.out.println("Enter all the element: ");
         for (int i=0;i<n;i++){
            y=sc.nextInt();
         root = insert(root, y);
         }
         do {
        System.out.println(" 1. Add a node \n 2. Delete a node \n 3. Show minimum node \n 4. Show maximum node \n 5. Find a node \n 6. Print all nodes \n 7. Exit");
        System.out.print("Enter your choice: ");
         x= sc.nextInt(); 
        switch (x){
            case 1:   
                System.out.println("Enter a new node: ");
                int e=sc.nextInt();
                    root = insert(root, e);
                        break;
            case 2:     System.out.println("Enter the node you want to delete: ");
                        int d=sc.nextInt();
                        delete(root,d);
                        break;
            case 3:   System.out.println(min(root).data);
                        break;
            case 4:   System.out.println(max(root).data);
                        break;
            case 5:     System.out.println("Enter the node you want to find: ");
                        int f=sc.nextInt();
                        search(root,f);
                        break;          
            case 6:     inorder(root); System.out.println("");
                        break; 
            case 7:break; 
            default:  System.out.println("Entrance is not in range, Try again");  }

         }while(x!=7);
    
    
}   }

