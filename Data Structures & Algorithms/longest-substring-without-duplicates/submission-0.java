class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        else if(s.length()==1){
            return 1;
        }
        int max=0;
        int left=0;
        HashSet <Character> set=new HashSet <>();
        int n=s.length();
        for(int right=0;right<n;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            max = Math.max(max, set.size());
        }
        return max;
    }
}
