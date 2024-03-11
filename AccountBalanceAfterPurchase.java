class AccountBalanceAfterPurchase {
    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundAmt=0;
        if(purchaseAmount<10){
            if(purchaseAmount>=5){
                roundAmt=10;
            }
            purchaseAmount=0;
        }
        else{
            int rem=purchaseAmount%10;
            purchaseAmount=purchaseAmount-rem;
            roundAmt=(rem>=5)?10:0;
        }
        return 100-purchaseAmount-roundAmt;
    }
    public static void main(String[] args){
        System.out.println(accountBalanceAfterPurchase(15));
    }
}