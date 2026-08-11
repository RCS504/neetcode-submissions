class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];
        int[] output = {left, right};
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
            if (sum == target) {
                output = new int[] {left+1, right+1};
                return output;
            }
        }
        return output;
    }
}
