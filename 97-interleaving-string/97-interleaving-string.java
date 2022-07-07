class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        Map<String,Boolean> map = new HashMap<>();
        if(n1+n2 != n3) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        return isLeave(n1-1,n2-1,n3-1,c1,c2,c3,map);
    }
    
    boolean isLeave(int p1,int p2,int p3,char[] c1,char[] c2,char[] c3,Map<String,Boolean> map){
        
        if(p1<0 && p2<0 && p3<0) return true;
        String key = String.valueOf(p1)+'*'+String.valueOf(p2)+'*'+String.valueOf(p3);
        if(map.containsKey(key)) return map.get(key);
        if(p1 < 0){
            if(c2[p2] == c3[p3]){
                boolean ans = isLeave(p1,p2-1,p3-1,c1,c2,c3,map);
                map.put(key,ans);
                return ans;
            }
            else return false;
        }
        if(p2<0){
            if(c1[p1] == c3[p3]){
                boolean ans = isLeave(p1-1,p2,p3-1,c1,c2,c3,map);
                map.put(key,ans);
                return ans;
            }
            else return false;
        }
        
        boolean leftCall = false;
        boolean rightCall = false;
        if(c1[p1] == c3[p3]){
            leftCall = isLeave(p1-1,p2,p3-1,c1,c2,c3,map);
        }
        if(c2[p2] == c3[p3]){
            rightCall = isLeave(p1,p2-1,p3-1,c1,c2,c3,map);
        }
        boolean ans =leftCall || rightCall;
        map.put(key,ans);
        return ans;
    }
}