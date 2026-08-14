class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int have = 0;
        int need = 0;
        int best = Integer.MAX_VALUE;
        HashMap<Character, Integer> tFreq = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        String output = "";
        while (right != t.length()) {
            if (!tFreq.containsKey(t.charAt(right))) {
                tFreq.put(t.charAt(right), 1);
                right++;
                need++;
            } else {
                tFreq.put(t.charAt(right), tFreq.get(t.charAt(right)) + 1);
                right++;
            }
        }
        right = 0;
        while (right != s.length()) {
            if (!window.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), 1);

                right++;
            } else {
                window.put(s.charAt(right), window.get(s.charAt(right)) + 1);
                right++;
            }
            if (tFreq.containsKey(s.charAt(right - 1))
                && tFreq.get(s.charAt(right - 1)).equals(window.get(s.charAt(right - 1)))) {
                have++;
            }
            while (have == need) {
                int currentWindow = right - left;
                if (currentWindow < best) {
                    output = s.substring(left, right);
                }
                best = Math.min(best, currentWindow);
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                if (tFreq.containsKey(s.charAt(left))
                    && window.get(s.charAt(left)) < tFreq.get(s.charAt(left))) {
                    have--;
                }
                if (window.get(s.charAt(left)) == 0) {
                    window.remove(s.charAt(left));
                }
                left++;
            }
        }
        return output;
    }
}
