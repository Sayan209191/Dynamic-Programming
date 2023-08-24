import java.util.*;
public class LongestIncreasingSubsequence {

    public static int lcs(int nums1[], int nums2[]) {
        int n = nums1.length;
        int m = nums2.length;

        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<m+1; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
    public static int lis(int nums[]) {
        if(nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        int nums2[] = new int[set.size()];
        int idx = 0;
        for (int i : set) {
            nums2[idx++] = i;
        }
        Arrays.sort(nums2);

        return lcs(nums, nums2);
    }
    
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int totalMax = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            totalMax = Math.max(totalMax, dp[i]);
        }

        return totalMax;
    }

     
    public static void main(String[] args) {
        int nums[] = {50, 3, 10, 7, 40, 80};

        System.out.println(lis(nums));
    }
}

/*
class Solution 
{ 
    //binary search function finds the position of the first integer
    //in arr[] which is greater than or equal to 'value'.
    static int binarySearch(int arr[], int l, int h, int value)
    {
        //if new value is greater than all array values,
        //then it is placed at the end.
        if(value>arr[h]) 
            return h+1;
        
        //binary search algorithm.    
        while(h>l)
        {
            int middle = (h+l)/2;
            if(arr[middle] == value) 
                return middle;
            
            if(arr[middle] > value) 
                h = middle;
            
            else 
                l = middle + 1;
        }
        
        return h;
    }

    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        //tail[i] holds the last value in a subsequence of length i+1.
        int[] tail = new int[size];
        tail[0] = a[0];
        
        //the position of last filled index in tail[].
        int lastIndex = 0; 
        
        for(int i=1; i<size; i++)
        {
            //getting the furthest possible index for a[i].
            int index = binarySearch( tail, 0, lastIndex, a[i] );
            
            tail[index] = a[i];
            //updating lastIndex.
            lastIndex = Math.max( lastIndex, index );
        }
        //returning the result.
        return lastIndex + 1;
    }

} 
 */