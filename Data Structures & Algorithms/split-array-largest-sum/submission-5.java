class Solution {
    public int splitArray(int[] nums, int k) {
        int minval=0;
        int maxval=0;
        for(int num: nums){
            minval=Math.max(num,minval);
            maxval += num;
        }
        while(minval < maxval){
            int mid=minval+(maxval-minval)/2;
            if(possibleMinval(nums,k,mid)){
                maxval=mid;
            }
            else {
                minval=mid+1;
            }
        }
        return minval;
    }

    private boolean possibleMinval(int[] nums, int k,int minval){
        int subArray=1;
        int currentSum=0;
        for(int num:nums){
            if(currentSum+ num>minval){
                subArray++;
                currentSum=num;
            }
            else {
                currentSum +=num;
            }
        }
        return subArray <=k;
    }
}