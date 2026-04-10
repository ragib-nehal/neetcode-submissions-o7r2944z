class Solution {
    public int climbStairs(int n) {
        // if n is 1 or 2, the answer is just n itself
        if (n <= 2) {
            return n;
        }
        
        // dp[i] = number of distinct ways to climb i stairs
        int[] dp = new int[n + 1];
        
        // base cases
        dp[1] = 1; 
        dp[2] = 2;

        // each step can be reached from one step below or two steps below
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // answer for n stairs
        return dp[n];
    }
}