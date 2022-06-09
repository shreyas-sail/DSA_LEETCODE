class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Boolean[] visited = new Boolean[numCourses+1];
        Arrays.fill(visited,false);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        
        Boolean[] curDfs = new Boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(detectCycle(i,adj,visited,curDfs)){
                   System.out.println(i);
                   return new int[0]; 
                } 
            }
        }
        
        Stack<Integer> st = new Stack<>();
        Arrays.fill(visited,false);
        for (int i = 0; i < numCourses; i++){
            if(!visited[i]){
                dfs(i,adj,visited,st);
            }        
        }
        
        int[] order = new int[numCourses];
        System.out.println(st);
        int i =numCourses-1;
        while(!st.isEmpty()) {
            order[i--] = st.pop();
        }
        return order;
    }
        
    void dfs(int i,ArrayList<ArrayList<Integer>> adj,Boolean[] visited,Stack<Integer> st){
            visited[i] = true;
            for(Integer node:adj.get(i)){
                if(!visited[node]){
                    dfs(node,adj,visited,st);
                }
            }
            st.push(i);
    }
    
       Boolean detectCycle(int i,ArrayList<ArrayList<Integer>> adj,Boolean[] visited,Boolean[] curDfs){
           visited[i] = true;
           curDfs[i] = true;
            for(Integer node:adj.get(i)){
                if(!visited[node]){
                    if(detectCycle(node,adj,visited,curDfs)) return true;
                }else if(curDfs[node]){
                    return true;
                }
            }
           curDfs[i] = false;
           return false;
       }
    }    
    
