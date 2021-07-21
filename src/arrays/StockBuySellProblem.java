package arrays;

public class StockBuySellProblem {
    public static void main(String[] args) {
        int price[] = {3, 2, 6, 5, 0, 3};
        System.out.println(calculateMaxProfit(price, price.length));
    }

    private static int calculateMaxProfit(int[] price, int length) {
        int start = 0;
        int output = 0;
        while (start < length - 1 && price[start + 1] < price[start])
            start++;
        System.out.println("Out of loop" + start);
        if (start == length - 1)
            return 0;
        int sell = 0;
        while (sell < length - 1 && start < length - 1) {
            sell = start + 1;
            while (sell < length - 1 && price[sell + 1] > price[sell]) {
                sell++;
            }
            System.out.println("Buy: " + start + ", Sell: " + sell);
            output += price[sell] - price[start];
            start = sell + 1;
        }
        return output;
    }
}
