package binarytree.elements;

public class BinaryNode {
	
	private BinaryNode leftNode;
	private BinaryNode rightNode;
	private int iData;
	private char cData;
	
	public BinaryNode (int iData, char cData) {
		this.iData = iData;
		this.cData = cData;
	}
	
	public BinaryNode getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(BinaryNode leftNode) {
		this.leftNode = leftNode;
	}
	
	public BinaryNode getRightNode() {
		return rightNode;
	}
	
	public void setRightNode(BinaryNode rightNode) {
		this.rightNode = rightNode;
	}
	
	public int getiData() {
		return iData;
	}
	
	public void setiData(int iData) {
		this.iData = iData;
	}
	
	public char getcData() {
		return cData;
	}
	
	public void setcData(char cData) {
		this.cData = cData;
	}
}
