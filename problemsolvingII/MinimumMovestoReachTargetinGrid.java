public class MinimumMovestoReachTargetinGrid {
    public static void main(String[] args) {
        System.out.println(minMoves(5,6,3,4));
    }
    public static int minMoves(int sx, int sy, int tx, int ty) {
        int steps=0;
        while (tx!=sx || ty!=sy) {
            if(tx<sx || ty<sy){
                return -1;
            }
            steps++;
            if (tx > ty) {
                if (tx > ty * 2) {
                    if (tx % 2 != 0) {
                        return -1;
                    }
                    tx /= 2;
                } else {
                    tx -= ty;
                }
            } else if (tx < ty) {
                if (ty > tx * 2) {
                    if (ty % 2 != 0) {
                        return -1;
                    }
                    ty /= 2;
                } else {
                    ty -= tx;
                }
            } else {
                if (sx == 0) {
                    tx = 0;
                } else if (sy == 0) {
                    ty = 0;
                } else {
                    return -1;
                }
            }
        }
        return steps;
    }
    public int minMovesFast(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return 0;
        if (ty > tx) return minMovesFast(sy, sx, ty, tx);
        if (tx < sx || ty < sy) return -1;
        if (tx == ty) {
            if (sx == 0) tx = 0;
            else ty = 0;
        } else {
            if (tx < ty * 2) tx -= ty;
            else if (tx % 2 == 0) tx /= 2;
            else return -1;
        }
        int res = minMovesFast(sx, sy, tx, ty);
        if (res == -1) return -1;
        return 1 + res; 
    }
}