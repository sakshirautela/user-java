class NimGame {
    public boolean canWinNim(int n) {
        if(n<=0){
            return false;
        }
        canWinNim(n-1);
        
    }
}