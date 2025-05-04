public class Lift {
    int curr;
    int dest;
    boolean state;// stable
    int dir;

    public Lift(int curr, boolean state, int dir) {
        this.curr = curr;
        this.dest = curr;
        this.state = state;
        this.dir = dir;
    }

    public boolean getState() {
        return state;
    }

    public int getCurrFloor() {
        return curr;
    }

    public int getDir() {
        return dir;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setCurrFloor(int curr) {
        this.curr = curr;
    }

    public void setDir(int state) {
        this.dir = state;
    }
}
