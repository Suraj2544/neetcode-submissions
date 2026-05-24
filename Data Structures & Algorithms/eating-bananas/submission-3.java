class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minval=1;
        int maxval=0;
        for(int pile : piles){
            maxval=Math.max(pile,maxval);
        }
        while(minval < maxval){
            int mid = minval +(maxval-minval)/2;
            if(canEat(piles,h,mid)){
                maxval=mid;
            }
            else {
                minval=mid+1;
            }
        }
        return minval;
        
    }
    private boolean canEat(int[] piles,int h,int k){
        int hours=0;
        for(int pile : piles){
            hours += (pile + (k-1))/k;
        }
        return hours <= h;
    }
}
