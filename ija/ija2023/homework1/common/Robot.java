package ija.ija2023.homework1.common;

public class Robot {
    private int angle;
    private Environment env;
    private Position pos;

    protected Robot(Environment env, Position pos) {
        angle = 0;
        this.env = env;
        this.pos = pos;
    }

    public static Robot create(Environment env, Position pos) {
        Robot robot = new Robot(env, pos);
        if (!robot.isEmpty(pos)) {
            return null;
        }
        env.addRobot(robot);
        return robot;
    }

    public int angle() {
        return angle;
    }

    public boolean canMove() {
        Position pos = this.pos.move(angle);
        return isEmpty(pos);
    }

    public Position getPosition() {
        return pos;
    }

    public boolean move() {
        Position pos = this.pos.move(angle);
        if (!isEmpty(pos)) {
            return false;
        }
        this.pos = pos;
        return true;
    }

    public void turn() {
        angle += 45;
        if (angle >= 360) {
            angle -= 360;
        }
    }

    protected boolean isEmpty(Position pos) {
        return env.containsPosition(pos)
            && !env.obstacleAt(pos)
            && !env.robotAt(pos);
    }

    @Override
    public String toString() {
        return "Robot { angle: " + angle + ", pos: " + pos + " }";
    }
}
