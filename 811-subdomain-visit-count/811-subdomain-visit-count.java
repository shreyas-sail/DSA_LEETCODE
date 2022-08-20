class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(String s:cpdomains){
            String[] intStringList = s.split(" ");
            int num = Integer.parseInt(intStringList[0]);
            String onlyString = intStringList[1];
            int ind = onlyString.indexOf('.');
            while(ind > 0){
                if(map.containsKey(onlyString)){
                    int n = map.get(onlyString);
                    map.put(onlyString,n+num);
                }else{
                    map.put(onlyString,num);
                }
                ind = onlyString.indexOf('.');
                onlyString = onlyString.substring(ind+1);
            }
            
        }
        
        for(String s:map.keySet()){
            String newS = String.valueOf(map.get(s)) +" "+ s;
            ans.add(newS);
        }
        
        return ans;
    }
}