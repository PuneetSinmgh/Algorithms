package my.com.app.heightbalancedbst;

public class AVLTree {

    private class Node {
        int key;
        int height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    private Node root;

    public AVLTree() {
        root = null;
    }

    // Function to get the height of the tree
    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Function to get the balance factor of a node
    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public void insert(int key) {
        root = insertNode(root, key);
    }

    public Node insertNode(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        } else {
            // Duplicate keys are not allowed in the AVL tree
            return node;
        }
        
        // new node has been added, so we need to update the height of this ancestor node
        // Update the height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether
        // this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case : Left heavy 
        // If the node is left heavy, then we need to do a right rotation
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Right Right Case : Right heavy
        // If the node is right heavy, then we need to do a left rotation
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left Right Case : Left heavy but right child is heavy
        // If the node is left heavy but right child is heavy, then we need to do
        // a left rotation on the left child followed by a right rotation on the node
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case : Right heavy but left child is heavy
        // If the node is right heavy but left child is heavy, then we need to do
        // a right rotation on the right child followed by a left rotation on the node
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
    // Right rotate
    private Node rightRotate(Node y) {
        Node x = y.left;
        // Perform rotation
        y.left = x.right;
        x.right = y;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        // Return the new root
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;   
        y.left = x;

        x.height = Math.max( height(x.left), height(x.right)) + 1;
        y.height = Math.max( height(y.left), height(y.right)) + 1;
        // Return the new root
        return y;
    }

    // write a function to iterrate AVL tree in inorder traversal
    public void inorder() {
        inorderTraversal(root);
    }
    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
    }


    // Function to delete a node from the AVL tree
    private Node deleteNode(Node root, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null) {
            return root;
        }   
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                // No child case
                if (temp == null) {
                    return null;
                } else { // One child case
                    return temp;
                }
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);
                // Copy the inorder successor's content to this node
                root.key = temp.key;
                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }
        // If the tree had only one node then return
        if (root == null) {
            return root;
        }   

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = 1 + Math.max(height(root.left), height(root.right));  
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether this node became unbalanced)
        int balance = getBalance(root);
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private Node minValueNode(Node right) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'minValueNode'");
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }


}


