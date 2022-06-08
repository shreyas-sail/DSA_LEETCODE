class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Boolean[] visited = new Boolean[n+1];
        Arrays.fill(visited,false);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
            Queue<Integer> q = new LinkedList<>();
            q.offer(source);
            visited[source] = true;
            while(!q.isEmpty()){
                int popedNode = q.poll();
                if(popedNode == destination) return true;
                for(int i:adj.get(popedNode)){
                    if(!visited[i]){
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }
            return false;
    }
        
        
    // private createAdjList(int)
}