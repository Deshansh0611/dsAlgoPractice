package arrays;

public class StockBuySellProblem2 {
    public static void main(String[] args) {
        int prices[] = {3, 2, 6, 5, 0, 3};
        System.out.println(calculateMaxProfit(prices));
    }

    private static int calculateMaxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i<prices.length - 1; i++){
            if(prices[i+1] > prices[i])
                maxProfit += prices[i+1] - prices[i];
        }
        return maxProfit;
    }
}
