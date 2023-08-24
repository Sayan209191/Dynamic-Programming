public class LongestCommonSubstring {

    // Tabulation

    public static int lcsubTab(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];
        // intilization
        int max = 0;
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }
            }
        }
        // Filling
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s1 = "ABCDE";
        String s2 = "ADG";

        
        System.out.println(lcsubTab(s1, s2, s1.length(), s2.length()));
    }
}
