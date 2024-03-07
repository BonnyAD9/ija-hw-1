package ija.ija2023.homework1.room;

import java.util.ArrayList;

import ija.ija2023.homework1.common.Environment;
import ija.ija2023.homework1.common.Obstacle;
import ija.ija2023.homework1.common.Position;
import ija.ija2023.homework1.common.Robot;

public class Room implements Environment {
    private int width;
    private int height;

    private ArrayList<Robot> robots = new ArrayList<>();
    private ArrayList<Obstacle> obstacles = new ArrayList<>();

    private Room(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Room create(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Invalid room size");
        }
        return new Room(cols, rows);
    }

    private boolean isEmpty(Position pos) {
        return containsPosition(pos) && !robotAt(pos) && !obstacleAt(pos);
    }

    @Override
    public boolean addRobot(Robot robot) {
        if (!isEmpty(robot.getPosition())) {
            return false;
        }
        robots.add(robot);
        return true;
    }

    @Override
    public boolean containsPosition(Position pos) {
        int x = pos.getX();
        int y = pos.getY();
        return x >= 0 && x >= 0 && x < width && y < height;
    }

    @Override
    public boolean createObstacleAt(int row, int col) {
        Position pos = new Position(row, col);
        if (!isEmpty(pos)) {
            return false;
        }
        obstacles.add(new Obstacle(this, pos));
        return true;
    }

    @Override
    public boolean obstacleAt(int row, int col) {
        return obstacleAt(new Position(row, col));
    }

    @Override
    public boolean obstacleAt(Position p) {
        return obstacles.stream().anyMatch(o -> o.getPosition().equals(p));
    }

    @Override
    public boolean robotAt(Position p) {
        return robots.stream().anyMatch(r -> r.getPosition().equals(p));
    }
}
