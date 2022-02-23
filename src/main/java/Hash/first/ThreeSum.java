package Hash.first;

import java.util.*;

/**
 *  三数之和
 *  https://leetcode-cn.com/problems/3sum/
 *
 * @author 包成
 */
public class ThreeSum {

    public List<List<Integer>> doThreeSum(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int n = -nums[i] - nums[j];
                Integer m = map.get(n);
                if (m != null && m > j) {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(nums[i]);
                    innerList.add(nums[j]);
                    innerList.add(n);
                    list.add(innerList);
                }
            }
        }
        return list;
    }

    public List<List<Integer>> doThreeSum2(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            int c = nums.length - 1;
            for (int b = a + 1; b < nums.length; b++) {
                if (b > a + 1 & nums[b] == nums[b - 1]) {
                    continue;
                }

                while (c > b && nums[a] + nums[b] + nums[c] > 0) {
                    c--;
                }

                if (b == c) {
                    break;
                }

                if (nums[a] + nums[b] + nums[c] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    ret.add(list);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        threeSum.doThreeSum(nums);
    }

}
