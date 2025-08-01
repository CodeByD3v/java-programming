/*
4. Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 
Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
// Runtime 1ms Beats 100.00%
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length ; 
        int m = nums2.length ; 
        int[] arr = new int[n+m];
        int i = 0 , j = 0 , k = 0 ; 
        double middle = 0 ; 

        while (i < n && j < m ){
            if (nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else{
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        if (i == n){
            while (j < m ){
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }

        if (j == m){
            while (i < n ){
                arr[k] = nums1[i];
                i++;
                k++;
            }
        }

        if (arr.length % 2 != 0){
            middle = arr[arr.length / 2 ];    
        }
        else{
            middle = (arr[(arr.length/2)-1] +  arr[arr.length/2]) / 2.0;
        }

        return middle ; 
    }
}
