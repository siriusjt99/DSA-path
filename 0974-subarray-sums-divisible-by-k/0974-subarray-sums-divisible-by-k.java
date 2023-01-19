class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int cumSum = 0;
        HashMap<Integer, Integer> map = new HashMap<> ();
        int result = 0;
        map.put(0,1);
        for(int i =0; i< n; i++) {
            cumSum += nums[i];
            int rem = cumSum % k;
            if(rem < 0) rem = rem +k; // keeping reminder always positive
            int freq;
            if(map.containsKey(rem)) {
                freq = map.get(rem) +1;
                result += map.get(rem);
            } else {
                freq = 1;
            }
            map.put(rem ,freq);
        }
        return result;
    }
}