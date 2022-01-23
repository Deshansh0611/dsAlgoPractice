package dynamicProgramming;

import java.util.Arrays;

public class CoinChangeProblem {
    //Problem statement - https://leetcode.com/problems/coin-change
    public static void main(String[] args) {
        int[] coins = new int[]{186, 419, 83, 408};
        int amount = 6249;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.println(minCoinWithoutDP(coins, amount));
        System.out.println(minCoinWithDP(coins, amount, dp));
    }

    private static int minCoinWithoutDP(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<coins.length; i++) {
            if(amount - coins[i] >= 0) {
                int currAns = 0;
                currAns = minCoinWithoutDP(coins, amount - coins[i]);
                if(currAns != Integer.MAX_VALUE && currAns + 1 < ans)
                    ans = currAns + 1;
            }
        }
        return ans;
    }

    private static int minCoinWithDP(int[] coins, int amount, int[] dp) {
        if(amount == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<coins.length; i++) {
            if(amount - coins[i] >= 0) {
                int subAns = 0;
                if(dp[amount - coins[i]] != -1)
                    subAns = dp[amount - coins[i]];
                else
                    subAns = minCoinWithDP(coins, amount - coins[i], dp);
                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans)
                    ans = subAns + 1;
            }
        }
        dp[amount] = ans;
        return ans;
    }
}
