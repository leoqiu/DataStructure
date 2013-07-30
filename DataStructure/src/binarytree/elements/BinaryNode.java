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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinaryNode that = (BinaryNode) o;

        if (cData != that.cData) return false;
        if (iData != that.iData) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iData;
        result = 31 * result + (int) cData;
        return result;
    }
}
