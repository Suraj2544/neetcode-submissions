class FreqStack {
    HashMap <Integer,Integer> freqmap ;
    HashMap <Integer, Stack<Integer>> freqstack;
    int maxfreq;
    public FreqStack() {
        freqmap=new HashMap <>();
        freqstack=new HashMap <>();
        maxfreq=0;
    }
    
    public void push(int val) {
        int freq=freqmap.getOrDefault(val,0)+1;
        freqmap.put(val,freq);
        if(freq > maxfreq){
            maxfreq = freq;
        }
        if(!freqstack.containsKey(freq)){
            freqstack.put(freq,new Stack<>());
        }   
        freqstack.get(freq).push(val);
        
    }
    
    public int pop() {
        Stack <Integer> s=freqstack.get(maxfreq);
        int top=s.pop();
        if(s.isEmpty()){
            maxfreq--;
        }
        freqmap.put(top,freqmap.get(top)-1);
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */