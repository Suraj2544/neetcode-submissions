class Solution {
    public boolean isAnagram(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[] count=new int[26];
        for(int c:s.toCharArray()){
            count[c-'a']++;
        }
        for(int c:t.toCharArray()){
            count[c-'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i] !=0){
                return false;
            }
        }
        return true;
    }
}
