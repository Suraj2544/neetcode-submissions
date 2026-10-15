class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        char[] finalword=new char[m+n];
        int i=0;
        int j=0;
        while(j<m || j<n){
            if(j<m){
                finalword[i++]=word1.charAt(j);
            }
            if(j<n){
                finalword[i++]=word2.charAt(j);
            }
            j++;
        }
        
        return new String(finalword);
    }
}


