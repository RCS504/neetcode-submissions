class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        int right = 0;
        while (right != prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
                right++;
            } else {
                int total = prices[right] - prices[left];
                profit = Math.max(profit, total);
                right++;
            }
        }
        return profit;
    }
}
