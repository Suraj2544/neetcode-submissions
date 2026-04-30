class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        HashMap <Integer,Integer> freq =new HashMap <>();

        for(int card : hand){
            freq.put(card,freq.getOrDefault(card,0)+1);        
        }
        Arrays.sort(hand);
        for(int card : hand){
            if(freq.get(card)==0){
                continue;
            }

            for(int i=0;i<groupSize;i++){
                int needed= card+i;
                if(freq.getOrDefault(needed,0)==0){
                    return false;
                }

                freq.put(needed,freq.get(needed)-1);
            }
        }
        return true;
        
    }
}
