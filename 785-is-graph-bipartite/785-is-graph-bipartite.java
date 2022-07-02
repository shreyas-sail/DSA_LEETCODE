class Solution {
    // public boolean isBipartite(int[][] graph) {
    //     int numCourses = graph.length;
    //     int[] visited = new int[numCourses+1];
    //     Arrays.fill(visited,-1);
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    //     for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
    //     for (int i = 0; i < graph.length; i++) {
    //         if(graph[i].length>1){
    //             adj.get(graph[i][0]).add(graph[i][1]);
    //             adj.get(graph[i][1]).add(graph[i][0]);
    //         }
    //     }
    //     for (int i = 0; i < numCourses; i++){
    //         if(visited[i] == -1){
    //             if(!checkBipartite(i,adj,visited)){
    //                return false; 
    //             } 
    //         }
    //     }
    //     return true;
    // }
    //  Boolean checkBipartite(int i,ArrayList<ArrayList<Integer>> adj,int[] visited){
    //        Queue<Integer> q = new LinkedList<>();
    //        q.offer(i);
    //        visited[i] = 1;
    //         while(!q.isEmpty()){
    //         int poped = q.poll();
    //         for(Integer node:adj.get(poped)){
    //             if(visited[node] == -1){
    //                 visited[node] = 1 - visited[poped];
    //                 q.offer(node);
    //             }else if(visited[node] == visited[poped]){
    //                 return false;
    //             }
    //         }
    //     }
    //      return true;
    //  }
    public boolean isBipartite(int[][] graph) {
	var color = new int[graph.length];
	Arrays.fill(color, -1);

	for (var i = 0; i < graph.length; i++)
		if (color[i] == -1 && !bfs(i, graph, color))
			return false;
	return true;
}

private boolean bfs(int node, int[][] graph, int[] color) {
	var q = new ArrayDeque<>(List.of(node));
	color[node] = 0;

	while (!q.isEmpty()) {
		var curr = q.poll();
		for (var neighbor : graph[curr]) {
			if (color[neighbor] == color[curr])
				return false;
			if (color[neighbor] == -1) {
				color[neighbor] = 1 - color[curr];
				q.add(neighbor);
			}
		}
	}
	return true;
}
}