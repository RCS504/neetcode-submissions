class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftgroup = 1;
        int rightgroup = 1;
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = leftgroup;
            leftgroup *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= rightgroup;
            rightgroup *= nums[i];
        }
        return output;
    }
}
