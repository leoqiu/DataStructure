package binarytree.elements;

public class BinaryTree {
	
	
	
	/**
	 * build a binary search tree in binarytree1.dia
	 * 
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
		
		nodeI.setLeftNode(nodeP);
		nodeI.setRightNode(null);

		nodeK.setLeftNode(null);
		nodeK.setRightNode(nodeQ);
		
		nodeM.setLeftNode(null);
		nodeM.setRightNode(nodeR);
		
		nodeR.setLeftNode(nodeS);
		nodeR.setRightNode(null);

		nodeS.setLeftNode(null);
		nodeS.setRightNode(nodeT);
		
		nodeP.setLeftNode(null);
		nodeP.setRightNode(null);

		nodeQ.setLeftNode(null);
		nodeQ.setRightNode(null);
		
		nodeT.setLeftNode(null);
		nodeT.setRightNode(null);
		
		return nodeA;
	}
	
	
}
