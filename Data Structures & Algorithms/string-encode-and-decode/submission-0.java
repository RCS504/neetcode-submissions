class Solution {
    public String encode(List<String> strs) {
        String encoded_string = "";
        for (int i = 0; i < strs.size(); i++) {
            int length = strs.get(i).length();
            encoded_string += length + "#" + strs.get(i);
        }

        return encoded_string;
    }

    public List<String> decode(String str) {
        List<String> decoded_string = new ArrayList<>();
        String digit = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                digit += str.charAt(i);
            }
            if (str.charAt(i) == '#') {
                int length = Integer.parseInt(digit);
                String data = "";
                int k = i;
                for (int j = i + 1; j <= k + length; j++) {
                    data += str.charAt(j);
                    i++;
                }
                decoded_string.add(data);
                digit = "";
            }
        }
        return decoded_string;
    }
}
