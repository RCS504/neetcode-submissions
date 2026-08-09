class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int finalChain = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int chain = 1;
                int j = i;
                while (set.contains(j + 1)) {
                    chain += 1;
                    j++;
                }
                finalChain = Math.max(chain, finalChain);
            }
        }
        return finalChain;
    }
}
