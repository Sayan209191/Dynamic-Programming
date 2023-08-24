public class UnboundedKnapsack {
    // Recursion approch
    public static int knapsack(int val[], int wt[], int W, int idx) {
        if(idx == 0 || W == 0) {
            return 0;
        }
        if(wt[idx-1] <= W) {
            // case 1 : include
            int ans1 = val[idx-1] + knapsack(val, wt, W-wt[idx-1], idx);
            // case 2 : exclude
            int ans2 = knapsack(val, wt, W, idx-1);

            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, idx-1);

        }
    }

    // Memoization 

    public static int knapsackMemo(int val[], int wt[], int W, int idx, int dp[][]) {
        if(idx == 0 || W == 0) {
            return 0;
        }
        if(dp[idx][W] != -1) {
            return dp[idx][W];
        }
        if(wt[idx-1] <= W) {
            int ans1 = val[idx-1] + knapsack(val, wt, W-wt[idx-1], idx);
            int ans2 = knapsack(val, wt, W, idx-1);

            return dp[idx][W] = Math.max(ans1, ans2);
        } else {
            return dp[idx][W] = knapsack(val, wt, W, idx-1);

        }
    }

    // Tabulation approch

    public static int knapsackTab(int val[], int wt[], int W) {
        int dp[][] = new int[val.length+1][W+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                int v = wt[i-1];
                if(v<=j) {
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-v],dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        // print(dp);
        return dp[val.length][W];
    }
    // public static void print(int dp[][]) {
    //     for(int i=0; i<dp.length; i++) {
    //         for(int j=0; j<dp[0].length; j++) {
    //             System.out.print(dp[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    // }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        int dp[][] = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(val, wt, W, val.length));

        System.out.println(knapsackMemo(val, wt, W, val.length, dp));

        System.out.println(knapsackTab(val, wt, W));
    }
}
