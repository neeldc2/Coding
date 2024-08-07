package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeMain {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);
        root.right.left = new BinaryTreeNode(2);

        System.out.println("Level Order Traversal");
        {
            List<Integer> levelOrderTraversal = LevelOrderTraversal.traverse(root);
            printTraversal(levelOrderTraversal);
        }

        System.out.println("Inorder Traversal");
        {
            List<Integer> inorderTraversal = InorderTraversal.recursiveTraversal(root, new ArrayList<>());
            printTraversal(inorderTraversal);

            inorderTraversal = InorderTraversal.iterativeTraversal(root);
            printTraversal(inorderTraversal);
        }

        System.out.println("Preorder Traversal");
        {
            List<Integer> preorderTraversal = PreorderTraversal.recursiveTraversal(root, new ArrayList<>());
            printTraversal(preorderTraversal);

            preorderTraversal = PreorderTraversal.iterativeTraversal(root);
            printTraversal(preorderTraversal);
        }

        System.out.println("Postorder Traversal");
        {
            List<Integer> postorderTraversal = PostorderTraversal.recursiveTraversal(root, new ArrayList<>());
            printTraversal(postorderTraversal);

            postorderTraversal = PostorderTraversal.iterativeTraversal(root);
            printTraversal(postorderTraversal);

            postorderTraversal = PostorderTraversal.iterativeTraversalWithTwoStacks(root);
            printTraversal(postorderTraversal);
        }

        System.out.println("All traversals in one");
        {
            ThreeDFSTraversalInOne.allTraversals(root);
        }


        {
            int maxDepth = MaxDepth.maxDepthUsingLevelOrderTraversal(root);
            System.out.println("Max Depth of Binary tree: " + maxDepth);

            maxDepth = MaxDepth.maxDepthUsingRecursion(root);
            System.out.println("Max Depth of Binary tree: " + maxDepth);
        }

        {
            boolean isBalancedBinaryTree = BalancedBinaryTree.isBinaryTreeBalanced(root);
            System.out.println("Is the Binary Tree Balanced: " + isBalancedBinaryTree);
        }

        {
            int diameter;
            diameter = DiameterOfBinaryTree.getDiameter(root);
            System.out.println("Diameter of Binary Tree using Global variable: " + diameter);
            diameter = DiameterOfBinaryTreeAtomicInteger.getDiameter(root);
            System.out.println("Diameter of Binary Tree using Atomic Integer: " + diameter);
        }

        {
            int maxPathSum = MaximumPathSum.maxPathSum(root);
            System.out.println("Maximum Path Sum: " + maxPathSum);
        }

        {
            List<List<Integer>> verticalTraversal = VerticalOrderOfBinaryTree.verticalTraversal(root);
            System.out.println("Vertical Traversal: " + verticalTraversal);
        }

        {
            List<Integer> topView = TopViewBinaryTree.getView(root);
            System.out.println("Top View of Binary Tree: " + topView);
        }

        {
            List<Integer> bottomView = BottomViewBinaryTree.getView(root);
            System.out.println("Bottom View of Binary Tree: " + bottomView);
        }

        {
            boolean isSymmetric = IsBinaryTreeSymmetric.isSymmetric(root);
            System.out.println("Is Binary Tree Symmetric: " + isSymmetric);
        }

        System.out.println("Morris In-Order Traversal");
        {
            List<Integer> levelOrderTraversal = MorrisInorderTraversal.traverse(root);
            printTraversal(levelOrderTraversal);
        }

        {
            System.out.println("Constructing Binary Tree for PreOrder and Inorder");
            List<Integer> inorderTraversal = List.of(4,2,5,1,6,3,7);
            List<Integer> preorderTraversal = List.of(1,2,4,5,3,6,7);
            BinaryTreeNode resultingRoot = BinaryTreeFromInOrderAndPreOrder.constructTree(inorderTraversal, preorderTraversal);
            printTraversal(InorderTraversal.recursiveTraversal(resultingRoot, new ArrayList<>()));
            printTraversal(PreorderTraversal.recursiveTraversal(resultingRoot, new ArrayList<>()));
        }

        {
            System.out.println("Lowest Common Ancestor");
            BinaryTreeNode lca = LowestCommonAncestor.lowestCommonAncestor(root, root.left, root.right);
            // Node 2 is repeated. So output won't be correct. Code is correct, since it's tested with leetcode submission.
            System.out.println("Lowest Common Ancestor is: " + lca.val);
        }
    }

    public static void printTraversal(List<Integer> traversal) {
        System.out.println(
                traversal.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",")));
    }

}
