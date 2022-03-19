class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x =x;
        this.y =y;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));
        int oldColor = image[sr][sc];
        if(oldColor == newColor) return image;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int curX = p.x;
            int curY = p.y;
            image[curX][curY] = newColor;
            if(curY>0 && image[curX][curY-1] == oldColor){
                    q.offer(new Pair(curX,curY-1));
            }
            if(curY!=image[0].length-1 && image[curX][curY+1] == oldColor){
                    q.offer(new Pair(curX,curY+1));
            }
            if(curX>0  && image[curX-1][curY] == oldColor){
                    q.offer(new Pair(curX-1,curY));
            }
            if(curX!=image.length-1 && image[curX+1][curY] == oldColor){
                    q.offer(new Pair(curX+1,curY));
            }
        }
        return image;
    }
}