class Solution {
    public boolean isAnagram(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(n != m){
            return false; 
        }
        int[] count=new int [26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
         for(char c : t.toCharArray()){
            count[c-'a']--;
        }
        for( int val : count){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}
