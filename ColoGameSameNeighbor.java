class ColoGameSameNeighbor {
    public static boolean winnerOfGame(String colors) {
        int acount = 0, bcount = 0, a = 0, b = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                bcount=0;
                acount++;
                if (acount > 2) {
                    a++;
                }
            }
            else{
                acount = 0;
                bcount++;
                if (bcount > 2) {
                    b++;
                }
            }
        }
        if (b < a) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(winnerOfGame("AAAAABBBB"));
    }
}