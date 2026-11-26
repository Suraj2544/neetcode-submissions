/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
         int n = mountainArr.length();
        int peak=peakElement(mountainArr,n);
        int leftSearch=leftBinarySearch(mountainArr,target,0,peak);
        if(leftSearch!=-1){
            return leftSearch;
        }
        return rightBinarySearch(mountainArr,target,peak+1,n-1);
        
    }
    private int peakElement(MountainArray mountainArr,int n){
        int left=0;
        int right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return left;
    }

    private int leftBinarySearch(MountainArray mountainArr,int target,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            else if(mountainArr.get(mid)<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }

    private int rightBinarySearch(MountainArray mountainArr,int target,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            else if(mountainArr.get(mid)<target){
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return -1;
    }
}