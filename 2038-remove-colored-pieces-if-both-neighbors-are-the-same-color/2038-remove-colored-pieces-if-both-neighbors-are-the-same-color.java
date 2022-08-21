class Solution {
    public boolean winnerOfGame(String colors) {
       int countA =0 ,countB = 0,count = 0;
       for(Character c:colors.toCharArray()){
           if(c == 'A'){
               count++;
           }else{
               if(count>=3){
                   countA += count - 2;
               }
               count = 0;
           }
       }
        if(count>=3){
            countA += count - 2;
        }
       count = 0;
       for(Character c:colors.toCharArray()){
           if(c == 'B'){
               count++;
           }else{
               if(count>=3){
                   countB += count - 2;
               }
               count = 0;
           }
       }
        if(count>=3){
           countB += count - 2;
        }
        
        return countA>countB && countA!=countB;
    }
}