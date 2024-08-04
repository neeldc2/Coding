package stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode #496
 * Next Greater Element 1
 * <p>
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * <p>
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 */
public class NextGreaterElementOne {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        stack.push(nums2[nums2.length - 1]);
        Map<Integer, Integer> map = new HashMap();
        map.put(nums2[nums2.length - 1], -1);

        for (int i = nums2.length - 2; i >= 0; i--) {
            int stackTop = stack.peek();

            int number = nums2[i];
            while ((number > stackTop)) {
                stack.pop();

                if (stack.isEmpty()) {
                    break;
                }
                stackTop = stack.peek();
            }

            if (stack.isEmpty()) {
                map.put(number, -1);
            } else {
                map.put(number, stackTop);
            }

            stack.push(number);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int number = nums1[i];

            ans[i] = map.get(number);
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementOne nge = new NextGreaterElementOne();
        print(nge.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
    }

    private static void print(int[] ints) {
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
