class Solution {
    
    public boolean lemonadeChange(int[] bills) {
        int fi=0,ten=0,tt =0;
        for(int i:bills){
            if(i==5){
                fi++;
            }
            else if(i==10){
                ten++;
                if(fi>0){
                    fi--;
                }
                else{
                    return false;
                }
            }
            else{
                if(fi>0 && ten>0){
                    tt++;
                    fi--;
                    ten--;
                }
                else if(fi>2){
                    fi-=3;
                    tt++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}