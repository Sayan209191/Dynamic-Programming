public class LongestCommonSubsequence {
    // Recursion 
    public static int lcs(String str1, String str2, int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        if(str1.charAt(m-1) == str2.charAt(n-1)) {
            return 1+lcs(str1, str2, m-1, n-1);
        } else {
            return Math.max(lcs(str1, str2, m-1, n), lcs(str1, str2, m, n-1));
        }
    }

    // Memoization

    public static int lcsMemo(String str1, String str2, int m, int n, int dp[][]) {
        if(m == 0 || n == 0) {
            return 0;
        }
        if(dp[m][n] != -1) {
            return dp[m][n];
        }
        if(str1.charAt(m-1) == str2.charAt(n-1)) {
            return dp[m][n] = 1+lcs(str1, str2, m-1, n-1);
        } else {
            return dp[m][n] = Math.max(lcs(str1, str2, m-1, n), lcs(str1, str2, m, n-1));
        }
    }

    // Tabulation

    public static int lscTab(String str1, String str2, int m, int n) {
        int dp[][] = new int[m+1][n+1];

        // intilization 
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }
            }
        }

        // filling

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {  // Last character same
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    int ans1 = dp[i-1][j];   // String1 length - 1
                    int ans2 = dp[i][j-1];   // String2 length - 1
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[m][n];
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";

        int dp[][] = new int[str1.length()+1][str2.length()+1];

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        System.out.println(lcsMemo(str1, str2, str1.length(), str2.length(), dp));

        System.out.println(lscTab(str1, str2, str1.length(), str2.length()));
    }
}
