public class KnapsackProblem {
    // 0-1 Knapsack Problem 
    // Recursion Solution
    public static int knapsack(int val[], int wt[], int W, int idx) { // 2^n
        if(W ==0 || idx == 0) {
            return 0;
        }
        if(wt[idx-1] <= W) {
            // include
            int ans1 = val[idx-1]+knapsack(val, wt, W-wt[idx-1], idx-1);
            // exclude 
            int ans2 = knapsack(val, wt, W, idx-1);
            return Math.max(ans1, ans2);
        } else { // not valid 
            return knapsack(val, wt, W, idx-1);
        }

    }

    // Memoization
    public static int knapsackMemo(int val[], int wt[], int W, int idx,int dp[][]) { // n*W
        if(W ==0 || idx == 0) {
            return 0;
        }
        if(dp[idx][W] != -1) {
            return dp[idx][W];
        }
        if(wt[idx-1] <= W) {
            int ans1 = val[idx-1]+knapsackMemo(val, wt, W-wt[idx-1], idx-1, dp);
            int ans2 = knapsackMemo(val, wt, W, idx-1, dp);
            return dp[idx][W] = Math.max(ans1, ans2);
        } else {    
            return dp[idx][W] = knapsackMemo(val, wt, W, idx-1, dp);
        }

    }

    // Tabulation Method

    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        // intilization

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }

        // fill with buttom up approch

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }



    public static void main(String[] args) {
        // int val[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        // int W = 7;
        int val[] = {1,2,3};
        int wt[] = {4,5,1};
        int W=4; 
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapsack(val, wt, W, val.length));
        System.out.println(knapsackMemo(val, wt, W, val.length, dp));
        System.out.println(knapsackTab(val, wt, W));
    }
}