
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n]; // Next Smaller Element (Index)
        int[] pse = new int[n]; // Previous Smaller Element (Index)
        Stack<Integer> s = new Stack<>();

        // 1. Calculate Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            // If no smaller element exists to the right, use boundary 'n'
            nse[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        s.clear(); // Reuse the same stack

        // 2. Calculate Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            // If no smaller element exists to the left, use boundary '-1'
            pse[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        // 3. Calculate Max Area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
}