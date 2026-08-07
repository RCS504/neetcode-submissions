class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            bucket.get(frequency).add(number);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.size() - 1; i >= 0; i--) {
            for (int num : bucket.get(i)) {
                if (result.size() == k) {
                    break;
                } else {
                    result.add(num);
                }
            }
            if (result.size() == k) {
                break;
            }
        }
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            int num = result.get(i);
            output[i]=num;
        }
        return output;
    }
}