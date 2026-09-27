class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList <>();
        }
        HashMap <String,List <String>> map=new HashMap <>();
        for(String word : strs){
            char[] ch=word.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList <>());
            }
            map.get(key).add(word);
        }

        List<List<String>> result=new ArrayList <>();
        for(Map.Entry <String,List <String>> anagram : map.entrySet()){
            result.add(anagram.getValue ());
        }
        return result;
    }
}
