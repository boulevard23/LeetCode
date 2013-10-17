/**
 * Pascal's Triangle 2
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3, Return [1, 3, 3, 1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class Solution {
  public ArrayList<Integer> getRow(int rowIndex) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    if (rowIndex == 0) {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(1);
      return al;
    }
    ArrayList<Integer> al = getRow(rowIndex - 1);
    int tmp = 1;
    for (int i = 1; i < al.size(); i++) {
      int tmp2 = al.get(i);
      al.set(i, tmp + al.get(i));
      tmp = tmp2;
    }
    al.add(1);
    return al;
  }
}
