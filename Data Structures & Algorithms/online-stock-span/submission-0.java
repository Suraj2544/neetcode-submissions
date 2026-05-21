class StockSpanner {
    Stack <Integer> stack;
    ArrayList <Integer> result;
    public StockSpanner() {
        stack=new Stack <>();
        result=new ArrayList <>();
    }
    
    public int next(int price) {
       result.add(price);
       while (!stack.isEmpty() &&
               result.get(stack.peek()) <= price)  {
        stack.pop();
       }
       int previousGreaterElementIndex = stack.isEmpty() ? -1 : stack.peek();
       int currentElementIndex=result.size()-1;
       int ans=currentElementIndex - previousGreaterElementIndex;
       stack.push(currentElementIndex);
       return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */