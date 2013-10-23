package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/17/13
 *
 * http://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 */


class LetterNode {

    char val;
    int row;

    LetterNode (char val, int row) {
        this.val = val;
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LetterNode)) return false;

        LetterNode that = (LetterNode) o;

        if (row != that.row) return false;
        if (val != that.val) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) val;
        result = 31 * result + row;
        return result;
    }

    @Override
    public String toString() {
        return ""+val;
    }
}

public class LetterCombinationsPhoneNumber{

    char[] ones = {};
    char[] twos = {'a','b','c'};
    char[] threes = {'d','e','f'};
    char[] fours = {'g','h','i'};
    char[] fives = {'j','k','l'};
    char[] sixs = {'m','n','o'};
    char[] sevens = {'p','q','r','s'};
    char[] eights = {'t','u','v'};
    char[] nines = {'w','x','y','z'};
    char[] zeros = {};

    public ArrayList<String> letterCombinations(String digits) {

        ArrayList<String> res = new ArrayList<String>();
        if (digits.equals("")){
            res.add("");
            return res;
        }

        char[] chars = digits.toCharArray();

        ArrayList<LetterNode> listG = new ArrayList<LetterNode>();
        ArrayList<LetterNode> listStart = new ArrayList<LetterNode>();
        ArrayList<LetterNode> listEnd = new ArrayList<LetterNode>();
        int row = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '0' || chars[i] == '1') {

            }  else {

                if (chars[i] == '2'){
                    for (int j = 0; j < twos.length; j++) {
                        LetterNode lnode = new LetterNode(twos[j], row);
                        listG.add(lnode);
                    }
                } else if (chars[i] == '3') {
                    for (int j = 0; j < threes.length; j++){
                        LetterNode lnode = new LetterNode(threes[j], row);
                        listG.add(lnode);
                    }
                } else if (chars[i] == '4') {
                    for (int j = 0; j < fours.length; j++){
                        LetterNode lnode = new LetterNode(fours[j], row);
                        listG.add(lnode);
                    }
                } else if (chars[i] == '5') {
                    for (int j = 0; j < fives.length; j++){
                        LetterNode lnode = new LetterNode(fives[j], row);
                        listG.add(lnode);
                    }
                } else if (chars[i] == '6') {
                    for (int j = 0; j < sixs.length; j++){
                        LetterNode lnode = new LetterNode(sixs[j], row);
                        listG.add(lnode);
                    }
                } else if (chars[i] == '7') {
                    for (int j = 0; j < sevens.length; j++){
                        LetterNode lnode = new LetterNode(sevens[j], row);
                        listG.add(lnode);
                    }
                } else if (chars[i] == '8') {
                    for (int j = 0; j < eights.length; j++){
                        LetterNode lnode = new LetterNode(eights[j], row);
                        listG.add(lnode);
                    }
                } else {
                    for (int j = 0; j < nines.length; j++){
                        LetterNode lnode = new LetterNode(nines[j], row);
                        listG.add(lnode);
                    }
                }
                row++;
            }
        }

        for (int i = 0; i < listG.size(); i++) {
            LetterNode curNode = listG.get(i);
            if (curNode.row == 0)
                listStart.add(curNode);
            if (curNode.row == row-1)
                listEnd.add(curNode);
        }


        for (int i = 0; i < listStart.size(); i++) {
            LetterNode startNode = listStart.get(i);
            for (int j = 0; j < listEnd.size(); j++) {
                LetterNode endNode = listEnd.get(j);
                allPathsFromOneNodeToAnother(listG, startNode, endNode, new ArrayList<LetterNode>() , res);
            }
        }

        System.out.print(res);

        return res;

    }

    private void allPathsFromOneNodeToAnother (ArrayList<LetterNode> listG, LetterNode startNode, LetterNode endNode,
                                               ArrayList<LetterNode> path, ArrayList<String> res) {

        path.add(startNode);

        if(startNode.equals(endNode)) {
            ArrayList<LetterNode> aPath = new ArrayList<LetterNode>(path);
            //System.out.println(aPath);
            res.add(covertNodeListToStr(aPath));
        }

        for (int i = 0; i < listG.size(); i++) {
            LetterNode curNode = listG.get(i);
            //adjacent
            if (startNode.row == curNode.row-1)
                allPathsFromOneNodeToAnother(listG, curNode, endNode, path, res);
        }

        path.remove(path.size()-1);
    }

    private String covertNodeListToStr (ArrayList<LetterNode> aPath) {
        String res = "";
        for (int i = 0; i < aPath.size(); i++) {
            res = res+aPath.get(i).val;
        }
        return res;
    }

    public static void main (String[] args) {
        LetterCombinationsPhoneNumber s = new LetterCombinationsPhoneNumber();
        //String digits = "12304709";
        String digits = "";
        s.letterCombinations(digits);

    }




}
