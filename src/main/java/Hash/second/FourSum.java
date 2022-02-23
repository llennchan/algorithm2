package Hash.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 包成
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        if (length < 4) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();
        for (int a = 0; a < length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;

            for (int b = a + 1; b < length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                for (int c = b + 1; c < length; c++) {
                    if (c > b + 1 && nums[c] == nums[c - 1]) continue;

                    int dValue = target - nums[a] - nums[b] - nums[c];
                    int d = c + 1;
                    while (d < length) {
                        if (dValue == nums[d]) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[a]);
                            list.add(nums[b]);
                            list.add(nums[c]);
                            list.add(dValue);
                            ret.add(list);
                            break;
                        }
                        d++;
                    }
                }
            }
        }
        return ret;
    }

}
