// Leetcode Problem: https://leetcode.com/problems/richest-customer-wealth/
// Given a 2D array where each row represents a customer and each column an account,
// return the maximum wealth across all customers.

public class MaxWealth {
    public static void main(String[] args) {
        // No code here because this class is tested via Leetcode's online judge,
        // which calls the `maximumWealth()` method directly with test inputs.
    }

    public int maximumWealth(int[][] accounts) {
        // Each row = one customer
        // Each column = account balance of that customer

        int maxWealth = Integer.MIN_VALUE; // Track the richest customer's wealth

        // Iterate over each customer (i.e., each row)
        for (int[] customer : accounts) {
            int currentWealth = 0;

            // Sum all account balances for the current customer
            for (int account : customer) {
                currentWealth += account;
            }

            // Update maxWealth if this customer is richer
            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }

        return maxWealth;
    }
}
