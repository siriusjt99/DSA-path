class Solution {
    public int jump(int[] nums) {
        int i,n,j;
        n=nums.length;
        int [] pre = new int[n];
        for(i=0;i<n;i++)
        {
            // Initialize all the index position with some max value to denote it is unreachable
            pre[i] = Integer.MAX_VALUE;
        }
        
        // Make the first position value as 0 as it is the default place where we start
        pre[0] = 0;
		// Main condition check goes here.
        for(i=0;i<n;i++)
        {
            for(j=i;j<=i+nums[i] && j<n;j++)
            {
                pre[j] = Math.min(pre[j], pre[i]+1);
            }
        }
        return pre[n-1];
    }
}