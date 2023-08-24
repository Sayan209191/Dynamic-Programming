public class RodCutting {
    // Recursion (2^n)
    public static int maxValue(int length[], int price[], int rlen, int idx) {
        if(rlen == 0 || idx == 0) {
            return 0;
        }
        if(length[idx-1] <= rlen) {
            return Math.max(price[idx-1]+maxValue(length, price, rlen-length[idx-1], idx),
                             maxValue(length, price, rlen, idx-1));
        } else {
            return maxValue(length, price, rlen, idx-1);
        }
    }

    // Memoization (n*rodlength)
    public static int maxProfit(int length[], int price[], int rlen, int idx,int dp[][]) {
        if(rlen == 0 || idx == 0) {
            return 0;
        }
        if(dp[idx][rlen] != -1) {
            return dp[idx][rlen];
        }
        if(length[idx-1] <= rlen) {
            return dp[idx][rlen] = Math.max(price[idx-1]+maxValue(length, price, rlen-length[idx-1], idx),
                             maxValue(length, price, rlen, idx-1));
        } else {
            return dp[idx][rlen] = maxValue(length, price, rlen, idx-1);
        }
    }

    // Tabulation 

    public static int maxProfitDp(int length[], int price[], int rlen) {
        int n = price.length;
        int dp[][] = new int[n+1][rlen+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                int v = length[i-1];

                if(v <= j) {
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-v] , dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        print(dp);
        return dp[n][rlen];
    }
    public static void print(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodlen = 8; 

        int dp[][] = new int[price.length+1][rodlen+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(maxValue(length, price, rodlen, price.length));
        System.out.println(maxProfit(length, price, rodlen, rodlen, dp));

        System.out.println(maxProfitDp(length, price, rodlen));
    }
}
