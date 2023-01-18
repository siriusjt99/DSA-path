class Solution {
    public int Kadane(int[] nums){
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            maxSum=Math.max(nums[i],maxSum);
        }
        if(maxSum<0){
            return maxSum;
        }

        sum=0;
        maxSum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum<0){
                sum=0;
            }
            maxSum=Math.max(maxSum,sum);
        }

        return maxSum;

    }
    public int maxSubarraySumCircular(int[] nums) {
        // normal MaxsubArraySum
        int n=nums.length;
        int MaxSum1=Kadane(nums);
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
            nums[i]=-nums[i];
        }
        int MaxSum2=totalSum+Kadane(nums);
        return MaxSum1<0?MaxSum1:Math.max(MaxSum1,MaxSum2);

    }
}