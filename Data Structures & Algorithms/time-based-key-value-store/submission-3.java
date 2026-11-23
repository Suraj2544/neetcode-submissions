class TimeMap {
    static class pair{
        int timestamp;
        String value;
        pair(int timestamp,String value){
            this.timestamp=timestamp;
            this.value=value;
        }
    }
    HashMap <String,List<pair>> map;

    public TimeMap() {
        map=new HashMap <>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new pair(timestamp,value));
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List <pair> list=map.get(key);
        String result="";
        int left=0;
        int right=list.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid).timestamp == timestamp){
                return list.get(mid).value;
            }
            else if(list.get(mid).timestamp < timestamp){
                result=list.get(mid).value;
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return result;
    }
}
