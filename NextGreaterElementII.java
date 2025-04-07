// Time complexity:- O(n)
// Space complexity:- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Approach:
 * In this problem, I have to find the next greater element for each element in the circular array. 
 * I used a stack to keep track of the indices of the elements that have not yet found their next greater element. 
 * By iterating through the array twice (effectively simulating the circular nature of the array), I can efficiently 
 * calculate the next greater element for each index.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Stack to store indices of elements
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        
        // Initialize the result array with -1, assuming no greater element exists initially
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        // Brute-force approach with nested loop
        for (int i = 0; i < 2*n; i++) {
            // While the stack is not empty and the current number is greater than the number at the top of the stack
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]) {
                // Pop the index and assign the current number as the next greater element for that index
                int poppedIdx = st.pop();
                result[poppedIdx] = nums[i%n];
            }
            // Only push indices from the first round of iteration (0 to n-1)
            if(i < n) {
                st.push(i);
            }

        }       
        return result;
    }

}