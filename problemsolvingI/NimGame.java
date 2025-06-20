class NimGame {
    public boolean canWinNim(int n) {
        if (n <= 0) {
            return false;
        }
        return n % 4 != 0; // Winning condition for the Nim Game
    }
    public static void main(String[] args) {
        NimGame game = new NimGame();
        System.out.println(game.canWinNim(4)); // Output: false
        System.out.println(game.canWinNim(5)); // Output: true
    }
}
