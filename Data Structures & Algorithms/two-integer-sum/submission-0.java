class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int num1 = 0;
        int num2 = 0;
        int[] output = {num1, num2};

        for (int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            if (map.containsKey(goal)) {
                num1 = map.get(goal);
                num2 = i;

                output = new int[] {num1, num2};
            } else {
                map.put(nums[i], i);
            }
        }

        return output;
    }
}
