class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), (mapS.get(s.charAt(i)) + 1));
            } else {
                mapS.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), (mapT.get(t.charAt(i)) + 1));
            } else {
                mapT.put(t.charAt(i), 1);
            }
        }

        if (mapS.equals(mapT)) {
            return true;
        } else {
            return false;
        }
    }
}
