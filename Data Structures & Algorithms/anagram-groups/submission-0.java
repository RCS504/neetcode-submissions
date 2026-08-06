class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String string = strs[i];
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (!map.containsKey(sortedString)) {
                List<String> stringGroup = new ArrayList<>();
                stringGroup.add(strs[i]);
                map.put(sortedString, stringGroup);
            } else {
                List<String> stringGroup2 = map.get(sortedString);
                stringGroup2.add(strs[i]);
            }
            result = new ArrayList<>(map.values());
            
        }
        return result;
    }
}
