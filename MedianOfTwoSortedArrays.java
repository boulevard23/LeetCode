/**
 * Median of Two Sorted Arrays
 *
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

public class Solution {
  public double findMedianSortedArrays(int A[], int B[]) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    if (A.length > B.length)
      return findMedianSortedArray(A, B, 0, A.length - 1);
    else
      return findMedianSortedArray(B, A, 0, B.length - 1);
  }

  public double findMedianSortedArray(int A[], int B[], int left, int right) {
    int totalSize = A.length + B.length;
    if (left > right)
      return findMedianSortedArray(B, A,
          Math.max(0, (totalSize / 2 - A.length)),
          Math.min(B.length, totalSize / 2));
    int i = (right + left) / 2;
    int j = totalSize / 2 - i - 1;

    if (get(A, i) > get(B, j + 1))
      return findMedianSortedArray(A, B, left, i - 1);
    else if (get(A, i) < get(B, j))
      return findMedianSortedArray(A, B, i + 1, right);
    else {
      if (totalSize % 2 != 0) {
        return get(A, i);
      } else if (i > 0) {
        return (get(A, i) + Math.max(get(A, i - 1), get(B, j))) / 2.0;
      } else {
        return (get(A, i) + get(B, j)) / 2.0;
      }
    }
  }

  private int get(int[] a, int i) {
    if (i < 0)
      return Integer.MIN_VALUE;
    else if (i >= a.length)
      return Integer.MAX_VALUE;
    else
      return a[i];
  }
}
