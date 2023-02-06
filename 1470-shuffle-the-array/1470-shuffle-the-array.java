class Solution {
    public int[] shuffle(int[] nums, int n) {
        int res[]=new int[n*2];
        int p=0;
        int i=0;
        int j=n;
        while(j < nums.length && i < n)
        {
            res[p++]=nums[i];
            res[p++]=nums[j];
            i++;
            j++;
        }
        return res;
    }
}