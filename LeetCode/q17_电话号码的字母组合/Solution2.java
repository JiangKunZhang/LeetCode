package q17_电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/26 23:02
 */
public class Solution2 {

    String[] mapString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (digits.length() == 0) {
            return res;
        }
        dfs(res, sb, 0, digits);
        return res;
    }

    public void dfs(List<String> res, StringBuilder sb, int index, String digits) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String curStr = mapString[digits.charAt(index) - '0'];
        for (int i = 0; i < curStr.length(); i++) {
            sb.append(curStr.charAt(i));
            dfs(res, sb, index + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

