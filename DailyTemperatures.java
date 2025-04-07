// Time complexity:- O(n)
// Space complexity:- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * In this problem, I have to determine the number of days until a warmer temperature for each day in the 
 * input array. I used a stack to keep track of the indices of the temperatures where a warmer temperature has 
 * not yet been found. By iterating through the array and comparing the current temperature with the ones stored
 * in the stack, I can efficiently calculate the number of days for each temperature.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack to store the indices of the temperatures array
        Stack<Integer> st = new Stack<>();
        
        // Get the length of the temperatures array
        int n = temperatures.length;

        // Initialize the result array to store the number of days until a warmer temperature
        int[] result = new int[n];
        
        // Iterate through each temperature in the array      
        for (int i = 0; i < n; i++) {
            // Get the current temperature at index i
            int cur =   temperatures[i];
            // Check if the current temperature is greater than the temperature at the index stored in the stack
            while(!st.isEmpty() && cur > temperatures[st.peek()]) {
                // If so, pop the index from the stack, and calculate the number of days to the next warmer temperature
                int poppedIdx = st.pop();
                // The number of days is the difference between the current index and the popped index
                result[poppedIdx] = i - poppedIdx;
            } 
            // Push the current index onto the stack
            st.push(i);         
        }
        
        return result;
    }
}