package q1_TwoSum;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res=new int[2];
        $1_TwoSum test1=new $1_TwoSum();
        res = test1.twoSum(nums,target);
        System.out.println(Arrays.toString(res));
    }
}
