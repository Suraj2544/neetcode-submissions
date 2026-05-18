class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        int left =0;
        int right=n-1;
        while(right >=left){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            right--;
            left++;
        }
    }
}