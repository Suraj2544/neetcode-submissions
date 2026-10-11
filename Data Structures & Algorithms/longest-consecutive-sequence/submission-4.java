class Solution {
    public int longestConsecutive(int[] nums) {
        int maxcount=0;
        HashSet <Integer> set =new HashSet <>();
        for(int num : nums){
            set.add(num);
        }

        for(int n : nums){
            if(!set.contains(n-1)){
                int count=1;
                while(set.contains(n+1)){
                    count++;
                    n++;
                }
             maxcount=Math.max(count,maxcount);
            }
        }
        return maxcount;
    }
}
