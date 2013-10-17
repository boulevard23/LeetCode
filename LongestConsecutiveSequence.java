/**
 * Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */

public class Solution {
  public int longestConsecutive(int[] num) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    Set<Integer> s = new HashSet<Integer>();
    for (int i = 0; i < num.length; i++) {
      s.add(num[i]);
    }

    int max = 0;
    for (int i = 0; i < num.length; i++) {
      s.remove(num[i]);
      int length = getLength(num[i] + 1, s, true) + getLength(num[i] - 1, s, false) + 1;
      if (length > max) max = length;
    }
    return max;
  }

  private int getLength(int num, Set<Integer> s, boolean ascd) {
    int count = 0;
    while (s.contains(num)) {
      s.remove(num);
      count++;
      if (ascd) num++;
      else num--;
    }
    return count;
  }
}
