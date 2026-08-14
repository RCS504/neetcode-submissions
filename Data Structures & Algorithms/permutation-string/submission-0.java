class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> s1Frequency = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        while (right != s1.length()) {
            if (!s1Frequency.containsKey(s1.charAt(right))) {
                s1Frequency.put(s1.charAt(right), 1);
                right++;
            } else {
                s1Frequency.put(s1.charAt(right), s1Frequency.get(s1.charAt(right)) + 1);
                right++;
            }
        }
        right = 0;
        while (right != s2.length()) {
            if (!window.containsKey(s2.charAt(right))) {
                window.put(s2.charAt(right), 1);
                right++;
            } else {
                window.put(s2.charAt(right), window.get(s2.charAt(right)) + 1);
                right++;
            }
            if (right - left > s1.length()) {
                window.put(s2.charAt(left), window.get(s2.charAt(left)) - 1);
                if (window.get(s2.charAt(left)) == 0) {
                    window.remove(s2.charAt(left));
                }
                left++;
            }
            if (window.equals(s1Frequency)) {
                return true;
            }
        }

        return false;
    }
}
