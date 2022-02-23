package Hash.second;

import java.util.*;

/**
 * @author 包成
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3) return Collections.emptyList();

        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }

        for (int a = 0; a < length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;

            for (int b = a + 1; b < length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                Integer c = map.get(-nums[a] - nums[b]);
                if (c != null && c > b) {
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

}
