package LeetCode.BinaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/20/13
 *
 *
 *
 */




public class ConstructBinaryTreePreorderInorder {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        TreeNode root =  preorderBuildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

        System.out.print("");

        return root;
    }


    private TreeNode preorderBuildTree (int[] preorder, int leftP, int rightP, int[] inorder, int leftI, int rightI) {



        if(leftP > rightP || leftI > rightI)
            return null;
        else {

            int rootVal = preorder[leftP];
            TreeNode root = new TreeNode(rootVal);

            //find the pivot in inorder[]
            int pivot = 0;
            for (int i = leftI; i <= rightI; i++) {
                 if(inorder[i] == rootVal) {
                     pivot = i;
                     break;
                 }
            }

            int leftLen = pivot - leftI;
            //int rightLen = rightI - pivot;

            // inorder : [leftI, pivot-1]
            // inorder : [pivot+1, rightI]

            // preorder : [leftP+1, leftP+leftLen]
            // preorder : [leftP+leftLen+1, rightP]

            root.left = preorderBuildTree(preorder, leftP+1, leftP+leftLen, inorder, leftI, pivot-1);
            root.right = preorderBuildTree(preorder, leftP+leftLen+1, rightP, inorder, pivot+1, rightI);

            return root;
        }
    }

    public static void main (String[] args) {

        ConstructBinaryTreePreorderInorder s = new ConstructBinaryTreePreorderInorder();

        int[] preorder = {7,10,4,3,1,2,8,11};
        int[] inorder = {4,10,3,1,7,11,8,2};
        s.buildTree(preorder, inorder);
    }


}



































































































