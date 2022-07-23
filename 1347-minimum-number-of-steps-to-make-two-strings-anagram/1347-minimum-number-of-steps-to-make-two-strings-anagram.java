class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        
        for(int i = 0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
        }
        // System.out.println(Arrays.toString(count));
        for(int i = 0;i<t.length();i++){
            count[t.charAt(i) - 'a']--;
        }
        int ans = 0;
        for(int i:count){
            ans+=Math.abs(i);
        }
        // System.out.println(Arrays.toString(count));
        // for()
        return ans/2;
    }
}