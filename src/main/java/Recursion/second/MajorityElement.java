package Recursion.second;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        return _majorityElement(nums, 0, nums.length - 1);
    }

    private int _majorityElement(int[] nums, int left, int right) {
        if (left == 0 || right == 0 || left == right) return nums[left];

        int mid = (left + right) / 2;
        int leftRet = _majorityElement(nums, left, mid);
        int rightRet = _majorityElement(nums, mid + 1, right);

        if (leftRet == rightRet) return leftRet;

        int leftCount = count(nums, left, mid, leftRet);
        int rightCount = count(nums, mid, right, rightRet);
        return leftCount > rightCount ? leftRet : rightRet;
    }

    private int count(int[] nums, int left, int right, int target) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) count++;
        }
        return count;
    }

}
