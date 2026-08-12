class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        int tallestLeft = 0;
        int tallestRight = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                tallestLeft = Math.max(height[left], tallestLeft);
                total += tallestLeft - height[left];
                left++;
            }else{
                tallestRight = Math.max(height[right], tallestRight);
                total += tallestRight - height[right];
                right--;

            }
        }
        return total;
    }
}
