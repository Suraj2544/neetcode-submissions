class Solution {
    public String mergeAlternately(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();
        char[] word=new char[a+b];
        int i=0;
        int j=0;
        int k=0;

        while(i < a && j < b){
            word[k++]=word1.charAt(i++);
            word[k++]=word2.charAt(j++);
        }

        while(i < a){
            word[k++]=word1.charAt(i++);
        }

        while(j < b){
            word[k++]=word2.charAt(j++);
        }
        return new String(word);
    }
}