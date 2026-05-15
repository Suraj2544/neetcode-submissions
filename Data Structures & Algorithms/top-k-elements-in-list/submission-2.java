class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Step 1: Build frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min heap based on frequency
        PriorityQueue<Map.Entry<Integer,Integer>> pq=
        new PriorityQueue <>((a,b)-> a.getValue()-b.getValue());

        // Step 3: Keep only top k elements
        for(Map.Entry <Integer,Integer> entry : freqMap.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        // Step 4: Build result array
        int[] result =new int [k];
        int i=0;
        while(!pq.isEmpty()){
            result[i]=pq.poll().getKey();
            i++;
        }
        return result;
    }
}