/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 *
 */


// It is a recursive way. Permutation and combination are all like dfs.
// But unfortunately, this solution exceeded the time limit.
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return dfs(n, k);
    }

    private ArrayList<ArrayList<Integer>> dfs(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                result.add(tmp);
            }
        } else {
            for (int i = n; i > 1; i--) {
                ArrayList<ArrayList<Integer>> res = dfs(n - 1, k - 1);
                for (ArrayList<Integer> cur : res) {
                    cur.add(i);
                    result.add(cur);
                }
            }
        }
        return result;
    }
}
