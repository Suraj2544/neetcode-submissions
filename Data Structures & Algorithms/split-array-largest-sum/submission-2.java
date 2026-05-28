class Solution {
    public int splitArray(int[] nums, int k) {
        int minval=0;
        int maxval=0;
        for(int num : nums){
            minval = Math.max(minval,num);
            maxval += num;
        }
        while(minval < maxval){
            int mid=minval +(maxval-minval)/2;
            if(possibleminval(nums,k,mid)){
                maxval=mid;
            }
            else {
                minval=mid+1;
            }
        }
        return minval;
    }
    private boolean possibleminval(int[] nums, int k,int minval){
        int subarray=1;
        int currentsum=0;
        for(int num : nums){
            if(currentsum + num > minval){
                subarray++;
                currentsum=num;
            }else {
                currentsum += num;
            }
        }
        return subarray <= k;
    }
}
