class Solution {
    public int characterReplacement(String s, int k) {
        int output = 0;
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> frequency = new HashMap<>();
        while (right != s.length()) {
            if (!frequency.containsKey(s.charAt(right))) {
                frequency.put(s.charAt(right), 1);
            } else {
                frequency.put(s.charAt(right), frequency.get(s.charAt(right)) + 1);
            }
            maxFreq = Math.max(maxFreq, frequency.get(s.charAt(right)));
            while ((right - left + 1) - maxFreq > k) {
                frequency.put(s.charAt(left), frequency.get(s.charAt(left)) - 1);
                left++;
            }
            output = Math.max(output, (right - left + 1));
            right++;
        }
        return output;
    }
}
