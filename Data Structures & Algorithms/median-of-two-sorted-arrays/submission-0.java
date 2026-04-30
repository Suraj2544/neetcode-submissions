class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int[] merge =new int [n+m];
        int i=0;
        int j=0;
        int k=0;
        while( i<n && j<m){
            if(nums1[i]<nums2[j]){
                merge[k++]=nums1[i++];
            }else{
                merge[k++]=nums2[j++];
            }
        }
        while(i<n){
            merge[k++]=nums1[i++];
        }
        while(j<m){
            merge[k++]=nums2[j++];
        }
        int total=m+n;

        if(total % 2==1){
            return merge[total/2];
        }
        else{
            return (merge[total/2] + merge[(total/2)-1]) / 2.0;
        }

    }
}
