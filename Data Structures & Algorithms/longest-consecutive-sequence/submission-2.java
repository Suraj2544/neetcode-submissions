class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount=0;
        HashSet <Integer> set=new HashSet <>();
        for(int num : nums){
            set.add(num);
        }

        for(int n : set){
            if(!set.contains(n-1)){
                int count =1;
                while(set.contains(n+1)){
                    count++;
                    n++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount ;
    }
}
