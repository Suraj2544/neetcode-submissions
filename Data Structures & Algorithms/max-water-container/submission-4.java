class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int left=0;
        int right=n-1;
        int maxArea=0;
        while(left <= right){
            int minHeight=Math.min(heights[left],heights[right]);
            int area=(right-left)* minHeight;
            maxArea=Math.max(area,maxArea);
            if(heights[left]<heights[right]){
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }
}
