class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(sum, 0) + nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
    
    //Before optimize
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
