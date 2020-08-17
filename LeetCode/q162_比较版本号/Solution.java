package q162_比较版本号;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/28 8:15
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");
        int len1 = strings1.length;
        int len2 = strings2.length;
        int val1 = 0;
        int val2 = 0;
        //长度不够的当 0 看
        for (int i = 0; i < Math.max(len1,len2); i++) {
            val1 = i < len1 ? Integer.parseInt(strings1[i]) : 0;
            val2 = i < len2 ? Integer.parseInt(strings2[i]) : 0;
            if (val1 > val2) {
                return 1;
            }else if (val1 < val2)  {
                return -1;
            }
        }
        return 0;
    }
}
