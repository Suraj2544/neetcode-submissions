class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List <Integer> result =new ArrayList <>();
        for(int key : map.keySet()){
            if(map.get(key) > n/3){
                result.add(key);
            }
        }
        return result;
    }
}