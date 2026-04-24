class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap <Integer,Integer> val = new HashMap <>();
        for(int num : nums){
            val.put(num,val.getOrDefault(num,0)+1);

            if(val.get(num)> 1){
                return true;
            }
        }
        return false;
    }
}