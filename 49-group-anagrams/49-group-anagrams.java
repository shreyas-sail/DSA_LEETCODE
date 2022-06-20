class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> mainMap = new HashMap<>();
        for(String word:strs){
            Map<Character,Integer> wordMap = new HashMap<>(); 
            for(Character c:word.toCharArray()){
                wordMap.put(c,wordMap.getOrDefault(c,1)+1);
            }
            if(mainMap.containsKey(wordMap)){
                List<String> s = mainMap.get(wordMap);
                s.add(word);
                mainMap.put(wordMap,s);
            }else{
                List<String> s = new ArrayList<String>();
                s.add(word);
                mainMap.put(wordMap,s);
            }
            // mainMap.put(wordMap,mainMap.getOrDefault(wordMap,).add(word));
        }
        List<List<String>> ans  = new ArrayList<List<String>>();
        for(List<String> li:mainMap.values()){
            ans.add(li);
        }
        return ans;
    }
}