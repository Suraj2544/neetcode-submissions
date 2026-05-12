class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null){
            return new ArrayList <>();
        }
        HashMap <String,List<String>> GroupAnagramMap =new HashMap <>();
        for(String s : strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
           String key = new String(ch);

            if(!GroupAnagramMap.containsKey(key)){
                GroupAnagramMap.put(key,new ArrayList <>());
            }

            GroupAnagramMap.get(key).add(s);
        }
        List<List<String>> result = new ArrayList <>();

        for(Map.Entry <String,List<String>> GroupAnagram : GroupAnagramMap.entrySet()){
            result.add(GroupAnagram.getValue());
        }

        return result;
    }
}
