import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
      
        if (amount == 0) return 0;

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        dp[0] = 0; // base case

     
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solver = new CoinChange();

        // Test cases
        System.out.println(solver.coinChange(new int[]{1, 2, 5}, 11)); // Output: 3
        System.out.println(solver.coinChange(new int[]{2}, 3));        // Output: -1
        System.out.println(solver.coinChange(new int[]{1}, 0));        // Output: 0
    }
}
