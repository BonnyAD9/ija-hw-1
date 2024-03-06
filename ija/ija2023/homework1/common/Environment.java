public interface Environment {
    boolean addRobot(Robot robot);

    boolean containsPosition(Position pos);

    boolean createObstacleAt(int row, int col);

    boolean obstacleAt(int row, int col);

    boolean obstacleAt(Position p);

    boolean robotAt(Position p);
}
