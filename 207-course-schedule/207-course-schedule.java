class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       Boolean[] visited = new Boolean[numCourses+1];
        Arrays.fill(visited,false);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Boolean[] curDfs = new Boolean[numCourses];
        Arrays.fill(curDfs,false);
        for (int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(detectCycle(i,adj,visited,curDfs)){
                   return false; 
                } 
            }
        }
        return true;
        
    }
        
        Boolean detectCycle(int i,ArrayList<ArrayList<Integer>> adj,Boolean[] visited,Boolean[] curDfs){
           visited[i] = true;
           curDfs[i] = true;
            for(Integer node:adj.get(i)){
                if(!visited[node]){
                    if(detectCycle(node,adj,visited,curDfs)){ 
                        return true;
                    }
                }else if(curDfs[node]){
                    return true;
                }
            }
           curDfs[i] = false;
           return false;
       }
    
}