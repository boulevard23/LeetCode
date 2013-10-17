/**
 * Reverse Integer
 *
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 */

public class Solution {
  public int reverse(int x) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    String s = Integer.toString(x);
    int size = s.length();
    int index;
    for (index = size - 1; index > 0 && s.charAt(index) == '0'; index--);
    StringBuilder sb = new StringBuilder();
    if (s.charAt(0) == '-') {
      sb.append('-');
      for (int i = index; i > 0; i--) {
        sb.append(s.charAt(i));
      }
    } else {
      for (int i = index; i >= 0; i--) {
        sb.append(s.charAt(i));
      }
    }
    return Integer.parseInt(sb.toString());
  }
}
