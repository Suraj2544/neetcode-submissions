class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs ==null && strs.length == 0){
            return new ArrayList<>();
        }

        Map <String,List<String>> GroupAnagramMap =new HashMap <>();

        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key =new String(ch); 

            if(!GroupAnagramMap.containsKey(key)){
                GroupAnagramMap.put(key,new ArrayList <>());
            }

            GroupAnagramMap.get(key).add(s);
        }

        List<List<String>> resultList =new ArrayList <>();
        for(Map.Entry<String,List<String>> GroupAnagram : GroupAnagramMap.entrySet()){
            resultList.add(GroupAnagram.getValue());
        }
        return resultList;
    }
}
