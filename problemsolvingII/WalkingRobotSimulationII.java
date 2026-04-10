public class WalkingRobotSimulationII {
    static void main() {
        String[] calls = {"Robot", "step", "step", "getPos", "getDir", "step", "step", "step", "getPos", "getDir"};
        int[][] vals = {{6, 3}, {2}, {2}, {}, {}, {2}, {1}, {4}, {}, {}};
        Robot r = null;
        for (int i = 0; i < calls.length; i++) {
            String call = calls[i];
            int[] val = vals[i];
            switch (call) {
                case "Robot":
                    r = new Robot(val[0], val[1]);
                    System.out.println("null");
                    break;
                case "step":
                    r.step(val[0]);
                    System.out.println("null");
                    break;
                case "getPos":
                    int[] p = r.getPos();
                    System.out.println(p[0] + " " + p[1]);
                    break;
                default:
                    System.out.println(r.getDir());
            }
        }
    }

    /**
     * class Robot {
     * <p>
     * int direction;
     * String[] directionName;
     * int width, height;
     * int[] position;
     * int[][] stepMovement;
     * int num;
     * <p>
     * public Robot(int width, int height) {
     * this.width = width;
     * this.height = height;
     * this.position = new int[2];
     * this.position[0] = 0;
     * this.position[1] = 0;
     * this.direction = 0;
     * this.directionName = new String[]{"East", "North", "West", "South"};
     * this.stepMovement = new int[][]{{1,0},  {0,1}, {-1, 0}, {0, -1}};
     * this.num = 0;
     * <p>
     * }
     * <p>
     * private void lazyStep(int num){
     * num = num%(2*(this.width + this.height) - 4);
     * if(num == 0){
     * num = 2*(this.width + this.height) - 4;
     * }
     * while(num > 0){
     * switch(direction){
     * case 0:
     * if(this.position[0] + num > this.width - 1){
     * num = num - (this.width - this.position[0] - 1);
     * this.direction = (this.direction + 1)%4;
     * this.position[0] = this.width-1;
     * }
     * else{
     * this.position[0] = this.position[0] + num;
     * num = 0;
     * }
     * break;
     * case 2:
     * if(this.position[0] - num < 0){
     * num = num - (this.position[0]);
     * this.direction = (this.direction + 1)%4;
     * this.position[0] = 0;
     * }
     * else{
     * this.position[0] = this.position[0] - num;
     * num = 0;
     * }
     * break;
     * case 1:
     * if(this.position[1] + num > this.height - 1){
     * num = num - (this.height - this.position[1] - 1);
     * this.direction = (this.direction + 1)%4;
     * this.position[1] = this.height - 1;
     * }
     * else{
     * this.position[1] = this.position[1] + num;
     * num = 0;
     * }
     * break;
     * case 3:
     * if(this.position[1] - num < 0){
     * num = num - (this.position[1]);
     * this.direction = (this.direction + 1)%4;
     * this.position[1] = 0;
     * }
     * else{
     * this.position[1] = this.position[1] - num;
     * num = 0;
     * }
     * break;
     * }
     * }
     * this.num = 0;
     * }
     * public void step(int num) {
     * this.num += num;
     * }
     * <p>
     * public int[] getPos() {
     * if(this.num > 0)
     * this.lazyStep(this.num);
     * return this.position;
     * }
     * <p>
     * public String getDir() {
     * if(this.num > 0)
     * this.lazyStep(this.num);
     * return this.directionName[this.direction];
     * }
     * }
     */
    static class Robot {
        int width, height;
        int step = 0;
        int perimeter;
        boolean moved = false;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.perimeter = 2 * (width + height) - 4;
        }

        public void step(int num) {
            moved = true;
            step = (step + num) % perimeter;
        }

        public int[] getPos() {
            int w = width - 1;
            int h = height - 1;

            if (step <= w) {
                return new int[]{step, 0};
            } else if (step <= w + h) {
                return new int[]{w, step - w};
            } else if (step <= 2 * w + h) {
                return new int[]{w - (step - (w + h)), h};
            } else {
                return new int[]{0, h - (step - (2 * w + h))};
            }
        }

        public String getDir() {
            if (!moved) return "East";

            int w = width - 1;
            int h = height - 1;

            if (step == 0) return "South";
            if (step <= w) return "East";
            if (step <= w + h) return "North";
            if (step <= 2 * w + h) return "West";
            return "South";
        }
    }
}