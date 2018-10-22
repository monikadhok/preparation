package oata.basics;

public class BST{
    class Node{
        int data;
        Node left;
        Node right;

        public Node(int value){
            data = value;
            left = null;
            right = null;
        }
    }

    Node root;

    //Delete 
    //Check if bst
    //Traversals 
    public void insert(int value){
       root =  insertLocal(value, root);
    }
    public Node insertLocal(int value, Node local){
        if(local == null){
            Node node = new Node(value);
           return node;
        } else if (local.data > value) {
            local.left =  insertLocal(value, local.left);
        } else if (local.data <= value) { 
            local.right = insertLocal(value, local.right);
        }
        return local;
    }

    public void print(){
        inorderTraversal(this.root);
    }

    public void inorderTraversal(Node node){
        if(node == null) return;
        inorderTraversal(node.left);
        System.out.println(node.data);
        inorderTraversal(node.right);
    }

    //delete 
    public void delete (int value){
       this.root =  delete(this.root, value);
    }

    public Node delete(Node node, int value){
        if(node == null)
            return null;
        else if (node.data > value)
            node.left =  delete(node.left, value);
        else if (node.data < value)
            node.right = delete(node.right, value);
        else {
            //found the node to be deleted

            //if no left child 
            if(node.left == null){
                return node.right;
            } else if (node.right == null){
                return node.left;
            } else {
                //Find the minimum value in right subtree and 
                //exchange that with this node

                Node tmp = node.right;
                while(tmp.left != null){
                    tmp = tmp.left;
                }
               // TODO
                int minValue = tmp.data;
                node.data = tmp.data;
                node.right =  delete(tmp, minValue);
            }
        }

        return node;
    }

    //search
    public boolean search(int value){
        return search(this.root, value);
    }

    public boolean search(Node node, int value){
        if(node == null)
            return false;
        if(node.data == value)
            return true;
        else if(node.data > value)
            return search(node.left, value);
        else 
            return search(node.right, value);
    }

    public static void main(String args[]){
        System.out.println("Hello world");
        BST bst = new BST();
        bst.insert(100);
        bst.insert(50);
        bst.insert(75);
        bst.insert(25);
        bst.insert(1);
        bst.insert(125);
        bst.insert(150);
        bst.insert(175);
        bst.insert(200);

        System.out.println("Printing the tree");
        bst.print();

        System.out.println("Searching 200 : " + bst.search(200));
        System.out.println("Searching 225 : " + bst.search(225));

        bst.delete(200);
        bst.delete(100);
        bst.delete(99);

        System.out.println("Printing the tree");
        bst.print();
    }
}