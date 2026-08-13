class Solution {
    public int lengthOfLongestSubstring(String s) {
        int output = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> longStr = new HashSet<>();
        while (right != s.length()) {
            while (longStr.contains(s.charAt(right))) {
                longStr.remove(s.charAt(left));
                left++;
            }
            longStr.add(s.charAt(right));
            int total = right - left + 1;
            output = Math.max(total, output);
            right++;
        }
        return output;
    }
}
