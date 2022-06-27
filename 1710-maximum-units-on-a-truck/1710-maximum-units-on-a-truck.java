class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(int[] o1, int[] o2) -> o2[1] - o1[1]);
        int iter = 0;
        int maxi = 0;
        while(truckSize != 0 && iter<boxTypes.length){
            if(truckSize > boxTypes[iter][0]){
                truckSize -= boxTypes[iter][0];
                maxi += boxTypes[iter][0]*boxTypes[iter][1];
            }else if(boxTypes[iter][0] >= truckSize){
                maxi += truckSize*boxTypes[iter][1];
                truckSize = 0;
            }
            iter++;
        }
        return maxi;
    }
}