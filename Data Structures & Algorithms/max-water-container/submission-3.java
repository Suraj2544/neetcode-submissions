class Solution {
    public int maxArea(int[] heights) {
        int maxArea =0;
        int i=0;
        int j=heights.length -1;
        while(i<j){
            int minHeight=Math.min(heights[i],heights[j]);
            int area=minHeight * (j-i);
            maxArea=Math.max(area,maxArea);
            if(heights[i]<heights[j]){
                i++;
            }
            else{
                j--;
            }
            
        }
        return maxArea;
    }
}
