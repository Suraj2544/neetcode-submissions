class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList <>();
        }
        HashMap <String,List<String>> map=new HashMap <>();
        for(String s: strs){
            char[] ch= s.toCharArray();
            Arrays.sort(ch);
            String key= new String (ch);

            if(!map.containsKey(key)){
                map.put(key,new ArrayList <>());
            }
            map.get(key).add(s);
        }
    List <List<String>> result =new ArrayList <>();
    for(Map.Entry <String,List<String>> val : map.entrySet()){
        result.add(val.getValue());
    }
    return result;
    }
}
