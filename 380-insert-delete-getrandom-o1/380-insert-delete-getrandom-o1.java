class RandomizedSet {
    Map<Integer,Integer> map ;
    List<Integer> arr;
    Random rnd = new Random();
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            arr.add(val);
            map.put(val,arr.size()-1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        
        if(map.containsKey(val)){
            
            int index = map.get(val);
            if(index == arr.size() -1){
               arr.remove(arr.size()-1);
                map.remove(val);
                return true; 
            }
            arr.set(index,arr.get(arr.size()-1));
            arr.remove(arr.size()-1);
            map.remove(val);
            map.put(arr.get(index),index);
            return true;
        }
        
        return false;
    }
    
    public int getRandom() {
        // int max = arr.size()-1;
        // int min = 0;
        // int range = max - min + 1;
        // int randomIndex = (int) (Math.random()*range)+min;
        // return arr.get(randomIndex);
        return arr.get(rnd.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */