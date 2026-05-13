class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap <Integer,Integer> freq =new HashMap <>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        } 

        int result=0;
        for(Map.Entry <Integer,Integer> val : freq.entrySet()){
            if(val.getValue() > n/2){
                return val.getKey();
            }
        }
        return 0;
    }
}