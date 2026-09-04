import java.util.*;

class BestTimeToBuyAndSellStock {
    static int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = s.nextInt();

        int[] a = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();

        System.out.println("Maximum Profit: " + maxProfit(a));
    }
}