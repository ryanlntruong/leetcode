/*
  There are two sorted arrays nums1 and nums2 of size m and n respectively.
  Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
  You may assume nums1 and nums2 cannot be both empty.

  Example 1:

  nums1 = [1, 3]
  nums2 = [2]

  The median is 2.0
  
  Example 2:

  nums1 = [1, 2]
  nums2 = [3, 4]

  The median is (2 + 3)/2 = 2.5
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        
        if(x > y)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = x;
        
        while(low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1)/2 - partitionX;
            
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxLeftX > minRightY)
                high = partitionX - 1;
            else if (maxLeftY > minRightX)
                low = partitionX + 1;
            else {
                int left = Math.max(maxLeftX, maxLeftY);
                int right = Math.min(minRightX, minRightY);
                if((x + y) % 2 == 0)
                    return (double) (left + right) / 2.0;
                else
                    return (double) left;
            }
        }
        
        return -1.0;
    }
}
