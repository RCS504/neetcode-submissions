class Solution {
    public int maxArea(int[] heights) {
        int output = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int width = right - left;
            int total = 0;
            if (heights[left] < heights[right]) {
                total = heights[left] * width;
                left++;

            } else {
                total = heights[right] * width;
                right--;
            }
            output = Math.max(output, total);
        }
        return output;
    }
}
