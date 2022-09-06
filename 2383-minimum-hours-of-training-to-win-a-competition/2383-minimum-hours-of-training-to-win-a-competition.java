class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int trainingHours = 0;
        for(int i = 0;i<energy.length;i++){
            if(initialEnergy <= energy[i]){
                trainingHours +=  energy[i] - initialEnergy + 1;
                initialEnergy += energy[i] - initialEnergy + 1;
            }
            
            if(initialExperience  <= experience[i]){
                trainingHours +=  experience[i] - initialExperience + 1;
                initialExperience +=  experience[i] - initialExperience + 1;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        
        return trainingHours;
    }
}