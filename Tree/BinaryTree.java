import java.util.*;

// Tree Data Structure Creation using a class called Tree
class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}

class binaryTrees {
    Tree root;

    binaryTrees() {
        this.root = null;
    }

    // Function to search a value in the tree
    public boolean search(int data) {
        if (root == null) {
            return false;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree current = queue.poll();
            if (current.data == data) {
                return true;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return false;
    }

    // Function to Insert a value in the Binary Tree using Level Order Traversal
    public void insert(int data) {
        Tree temp = new Tree(data);

        if (root == null) {
            root = temp;
            return;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree current = queue.poll();

            if (current.left == null) {
                current.left = temp;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = temp;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Function to delete a value in the Binary Tree
    public void delete(int key) {
        if (root == null) {
            return;
        }

        // If the tree is a single node
        if (root.left == null && root.right == null) {
            if (root.data == key) {
                root = null;
            }
            return;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        Tree nodeToDelete = null;
        Tree lastNode = null;

        // Perform level-order traversal to find the node to delete
        while (!queue.isEmpty()) {
            lastNode = queue.poll();

            if (lastNode.data == key) {
                nodeToDelete = lastNode;
            }

            if (lastNode.left != null) {
                queue.add(lastNode.left);
            }

            if (lastNode.right != null) {
                queue.add(lastNode.right);
            }
        }

        // If the node to delete was found
        if (nodeToDelete != null) {
            int lastNodeData = lastNode.data;
            deleteDeepest(lastNode);
            nodeToDelete.data = lastNodeData;
        }
    }

    // Function to delete the deepest node
    private void deleteDeepest(Tree node) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        Tree temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp == node) {
                temp = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == node) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == node) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }

    public void preorderTraversal(Tree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void inorderTraversal(Tree node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public void postorderTraversal(Tree node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        binaryTrees tree = new binaryTrees();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        System.out.println("Inorder traversal of the tree:");
        tree.inorderTraversal(tree.root);
        System.out.println();

        System.out.println("Preorder traversal of the tree:");
        tree.preorderTraversal(tree.root);
        System.out.println();

        System.out.println("Postorder traversal of the tree:");
        tree.postorderTraversal(tree.root);
        System.out.println();

        System.out.println("Deleting node 4:");
        tree.delete(4);
        tree.inorderTraversal(tree.root);
        System.out.println();

        System.out.println("Deleting node 1:");
        tree.delete(1);
        tree.inorderTraversal(tree.root);
        System.out.println();

        System.out.println("Deleting node 6:");
        tree.delete(6);
        tree.inorderTraversal(tree.root);
        System.out.println();
    }
}
