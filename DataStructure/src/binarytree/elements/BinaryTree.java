package binarytree.elements;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private static void printNode (BinaryNode node) {

        System.out.println("(" + node.getcData() + ":" + node.getiData() + ")");
    }
	
	/**
	 * build a binary search tree in binarytree1.dia
	 * mac
	 * @return
	 */
	public static BinaryNode buildBinaryTree1 () {
		
		BinaryNode nodeA = new BinaryNode(16, 'A');
		BinaryNode nodeB = new BinaryNode(9, 'B');
		BinaryNode nodeC = new BinaryNode(27, 'C');
		BinaryNode nodeD = new BinaryNode(6, 'D');
		BinaryNode nodeE = new BinaryNode(12, 'E');
		BinaryNode nodeF = new BinaryNode(19, 'F');
		BinaryNode nodeG = new BinaryNode(32, 'G');
		BinaryNode nodeH = new BinaryNode(2, 'H');
		BinaryNode nodeI = new BinaryNode(8, 'I');
		BinaryNode nodeJ = new BinaryNode(10, 'J');
		BinaryNode nodeK = new BinaryNode(14, 'K');
		BinaryNode nodeL = new BinaryNode(18, 'L');
		BinaryNode nodeM = new BinaryNode(22, 'M');
		BinaryNode nodeN = new BinaryNode(30, 'N');
		BinaryNode nodeO = new BinaryNode(36, 'O');
		BinaryNode nodeP = new BinaryNode(7, 'P');
		BinaryNode nodeQ = new BinaryNode(15, 'Q');
		BinaryNode nodeR = new BinaryNode(24, 'R');
		BinaryNode nodeS = new BinaryNode(23, 'S');
		BinaryNode nodeT = new BinaryNode(26, 'T');

        //mac
		nodeA.setLeftNode(nodeB);
		nodeA.setRightNode(nodeC);
		
		nodeB.setLeftNode(nodeD);
		nodeB.setRightNode(nodeE);
		
		nodeC.setLeftNode(nodeF);
		nodeC.setRightNode(nodeG);
		
		nodeD.setLeftNode(nodeH);
		nodeD.setRightNode(nodeI);
		
		nodeE.setLeftNode(nodeJ);
		nodeE.setRightNode(nodeK);
		
		nodeF.setLeftNode(nodeL);
		nodeF.setRightNode(nodeM);
		
		nodeG.setLeftNode(nodeN);
		nodeG.setRightNode(nodeO);

        nodeH.setLeftNode(null);
        nodeH.setRightNode(null);

		nodeI.setLeftNode(nodeP);
		nodeI.setRightNode(null);


        nodeJ.setLeftNode(null);
        nodeJ.setRightNode(null);

		nodeK.setLeftNode(null);
		nodeK.setRightNode(nodeQ);


        nodeL.setLeftNode(null);
        nodeL.setRightNode(null);

		nodeM.setLeftNode(null);
		nodeM.setRightNode(nodeR);


        nodeN.setLeftNode(null);
        nodeN.setRightNode(null);


        nodeO.setLeftNode(null);
        nodeO.setRightNode(null);

        nodeP.setLeftNode(null);
        nodeP.setRightNode(null);

        nodeQ.setLeftNode(null);
        nodeQ.setRightNode(null);

		nodeR.setLeftNode(nodeS);
		nodeR.setRightNode(null);

		nodeS.setLeftNode(null);
		nodeS.setRightNode(nodeT);

		nodeT.setLeftNode(null);
		nodeT.setRightNode(null);
		
		return nodeA;
	}
	
	public static void levelOrderPrintBinaryTree (BinaryNode root) {

        if(root == null)
            return;
        else {
            Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
            queue.offer(root);

            while(!queue.isEmpty()){

                root = queue.poll();
                printNode(root);

                if(root.getLeftNode() != null)
                    queue.offer(root.getLeftNode());

                if(root.getRightNode() != null)
                    queue.offer(root.getRightNode());


            }

        }

    }
}














