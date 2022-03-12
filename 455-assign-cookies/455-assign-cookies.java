class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length-1 < 0 || s.length -1 < 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i= 0,j = 0,countChild = 0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                i++;j++;
                countChild++;
            }else{
                j++;
            }
        }
        return countChild;
    }
}