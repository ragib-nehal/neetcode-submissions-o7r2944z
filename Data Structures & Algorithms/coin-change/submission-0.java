class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] = minimum coins needed to make amount i
        // size is amount+1 to include index 0 (base case)
        int[] dp = new int[amount + 1];

        // fill every amount with a value we know is impossible
        // (you can never need more than amount+1 coins, so this acts as "infinity")
        Arrays.fill(dp, amount + 1);

        // base case: 0 coins needed to make amount 0
        dp[0] = 0;

        // build up the answer for every amount from 1 to target
        for (int i = 1; i <= amount; i++) {

            // try every coin denomination
            for (int j = 0; j < coins.length; j++) {

                // only use this coin if it doesn't exceed the current amount
                if (coins[j] <= i) {
                    // option 1: dp[i] (best we found so far)
                    // option 2: use this coin once + best solution for the remainder
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // if dp[amount] is still "infinity", no valid combo exists -> return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}