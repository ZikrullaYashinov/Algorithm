package problems.leetcode.p2069;

import java.util.Arrays;

class Robot {

    int width, height;
    int[] pos;
    int dir;
    int box = 0;
    int circlePerimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        pos = new int[]{0, 0};
        dir = 0;
        circlePerimeter = (width + height - 2) * 2;
    }

    public void step(int num) {
        box += num;
    }

    void simulateStep(int num) {
        boolean increase = (dir % 4) < 2;
        if (dir % 2 == 0) {
            int diff = increase ? width - 1 - pos[0] : pos[0];
            if (num > diff) {
                pos[0] += diff * operator(increase);
                increaseDirection();
                simulateStep(num - diff);
            } else
                pos[0] += num * operator(increase);
        } else {
            int diff = increase ? height - 1 - pos[1] : pos[1];
            if (num > diff) {
                pos[1] += diff * operator(increase);
                increaseDirection();
                simulateStep(num - diff);
            } else
                pos[1] += num * operator(increase);
        }
    }

    void simulate() {
        dir += box / circlePerimeter;
        box %= circlePerimeter;
        simulateStep(box);
        box = 0;
    }

    private int operator(boolean increase) {
        return increase ? 1 : -1;
    }

    void increaseDirection() {
        dir = dir + 1;
    }

    public int[] getPos() {
        simulate();
        return pos;
    }

    public String getDir() {
        if (dir == 0)
            return "East";
        if (pos[0] == 0)
            return "South";
        if (pos[1] == 0)
            return "East";
        if (pos[0] == width - 1)
            return "North";
        return "West";
    }

    static void main() {
        Robot robot = new Robot(3, 3);
        robot.step(26);
        robot.step(34);
        robot.step(30);
        robot.step(45);
        robot.step(25);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(35);
        robot.step(33);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(1);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(1);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(10);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
    }
}