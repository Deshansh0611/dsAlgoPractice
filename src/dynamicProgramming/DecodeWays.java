package dynamicProgramming;

public class DecodeWays {
    //Problem statement - https://leetcode.com/problems/decode-ways/
    public static void main(String[] args) {
        String numToDecode = "117";
        System.out.println("Number of ways to decode " + numToDecode + " are: " + numberOfDecodings(numToDecode));
    }

    private static int numberOfDecodings(String num) {
        int[] dp = new int[num.length() + 1];
        dp[0] = 1;
        dp[1] = (num.charAt(0) == '0')? 0: 1;
        for(int i = 2; i<=num.length(); i++) {
            int oneDigit = Integer.valueOf(num.substring(i-1, i));
            int twoDigits = Integer.valueOf(num.substring(i-2, i));
            if(oneDigit >= 1)
                dp[i] += dp[i-1];
            if(twoDigits >= 10 && twoDigits <= 26)
                dp[i] += dp[i-2];
        }
        return dp[num.length()];
    }
}
