class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        // boolean[] sideVisit = new boolean[n];
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        // for(int i = 0;i<n;i++) adj.set(i,new ArrayList<Integer>());
        // for(int i = 0;i<n;i++){
        //     adj.get(rooms[i][0]).add(rooms[i][1]);
        //     adj.get(rooms[i][1]).add(rooms[i][0]);
        // }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()){
            Integer pop = q.poll();
            for(int j:rooms.get(pop)){
                if(!visited[j]){
                    q.offer(j);
                    visited[j] =true;
                    // sideVisit[j] =true;
                }
            }
        }
        for(int i = 0;i<visited.length;i++) if(!visited[i]) return false;
        return true;
    }
}