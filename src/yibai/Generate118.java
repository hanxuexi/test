package yibai;

import java.util.ArrayList;
import java.util.List;

public class Generate118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            list.add(i-1,help(i));
        }
        return list;
    }


    public List<Integer> help(int numRows) {
        if (numRows == 0) return null;
        List<Integer> temp = new ArrayList<>();
        if (numRows == 1) {
            temp.add(1);
            return temp;
        }
        if (numRows == 2) {
            temp.add(1);
            temp.add(1);
            return temp;
        }
        List<Integer> top = help(numRows-1);
        temp.add(1);

        for (int i = 1; i < numRows-1; i++) {
            temp.add(top.get(i - 1) + top.get(i));
        }
        temp.add(1);
        return temp;
    }
}
