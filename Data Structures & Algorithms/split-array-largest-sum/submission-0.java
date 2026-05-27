class Solution {
    public int splitArray(int[] nums, int k) {
        int left =0;
        int right=0;
        for(int num : nums){
            left=Math.max(left,num);
            right +=num;
        }

        while(left < right){
            int mid= left +(right-left)/2;
            if(cansplit(nums,k,mid)){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }

    private boolean cansplit(int[] nums, int k,int maxval){
        int subarray=1;
        int currentsum=0;

        for(int num : nums){
            if(currentsum + num > maxval){
                subarray++;
                currentsum = num;
            }
            else{
                currentsum += num;
            }
        }
        return subarray <= k;
    }
}