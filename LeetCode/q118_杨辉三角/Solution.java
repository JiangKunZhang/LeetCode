package q118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/14 15:18
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) {
            return ret;
        }
        List<Integer> oneRow = new ArrayList<>();
        ret.add(oneRow);
        ret.get(0).add(1);//第一行的元素 添加了一个1
        //直接从第2行开始进行计算
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);//当前行的第一个元素
            List<Integer> prevRow = ret.get(i - 1);//前一行
            for (int j = 1; j < i; j++) {
                //[i,j] = [i-1,j] +[i-1,j-1]
                int x = prevRow.get(j-1);
                int y = prevRow.get(j);
                curRow.add(x + y);
            }
            //最后一个元素
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }
}
