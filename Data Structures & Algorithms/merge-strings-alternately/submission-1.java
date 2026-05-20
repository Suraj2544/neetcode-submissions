class Solution {
    public String mergeAlternately(String word1, String word2) {
        int a=word1.length();
        int b=word2.length();
        char[] result =new char[a+b];
        int i=0;
        int j=0;
        int k=0;
        while( i < a && j < b){
            result[k++]=word1.charAt(i++);
            result[k++]=word2.charAt(j++);
        }
        while(i < a){
            result[k++]=word1.charAt(i++);
        }
        while(j < b){
            result[k++]=word2.charAt(j++);
        }
        return new String(result);
    }
}


