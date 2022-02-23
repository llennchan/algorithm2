package Hash.first;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author 包成
 */
public class TwoSum {

    public int[] doTwoSum(int[] nums, int target) {
        if (nums.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
