package trees;
import trees.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*! A single class for traversal algorithms for trees */
public class Search {

/*! build a simple tree.
            1
          /   \
         2     3
        / \   / \
       4   5 6   7
*/
    public static void main(String args[]) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        System.out.println("          1          ");
        System.out.println("         / \\         ");
        System.out.println("        2   3        ");
        System.out.println("       / \\ / \\       ");
        System.out.println("      4  5 6  7      ");
        System.out.print("Breadth first search:");
        bfs(tree);
        System.out.println();
        System.out.print("Depth first search:");
        dfs(tree);
        System.out.println();
    }

    /*! Also known as level order search. 
        proceeds through each node at each level,
        left to right.
        
        The algorithm works off the concept of a queue,
        1) dequeue the top node and output its value
        2) enqueue adjacent nodes
        3) repeat until queue is empty
     */
    public static void bfs(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        if (root == null) {
            return;
        }
        q.add(root);
        while(!q.isEmpty()) {
            Node n = (Node) q.remove();
            System.out.print(" " + n.val);
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
    }
    
    /*! the algorithm works off the concept of a stack.
        1) pop the top and output its value
        2) push left and right onto the stack
        3) repeat while stack is not empty
    */
    public static void dfs(Node root) {
        Stack<Node> s = new Stack<Node>();
        s.add(root);
        while (!s.isEmpty()) {
            Node n = s.pop();
            System.out.print(" " + n.val);
            if (n.right != null) {
                s.add(n.right);
            }
            if (n.left != null) {
                s.add(n.left);
            }
        }
    }
}
