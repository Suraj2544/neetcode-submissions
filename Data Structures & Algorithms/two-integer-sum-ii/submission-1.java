class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0){
            return new int[0];
        }
        int n=numbers.length;
        int[] result=new int[2];
        int i=0;
        int j=n-1;
        while(i<j){
            int sum=numbers[i]+numbers[j];
            if(sum==target){
                return new int[]{i+1,j+1};
            }
            if(sum>target){
                j--;
                continue;
            }
            if(sum < target){
                i++;
                continue;
            }
        }
        return new int[0];    
    }
}
