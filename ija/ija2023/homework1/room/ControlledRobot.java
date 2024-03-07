package ija.ija2023.homework1.room;

import ija.ija2023.homework1.common.Environment;
import ija.ija2023.homework1.common.Position;
import ija.ija2023.homework1.common.Robot;

public class ControlledRobot extends Robot {

    public ControlledRobot(Environment env, Position pos) {
        super(env, pos);
    }

    public static ControlledRobot create(Environment env, Position pos) {
        ControlledRobot robot = new ControlledRobot(env, pos);
        if (!robot.isEmpty(pos)) {
            return null;
        }
        env.addRobot(robot);
        return robot;
    }
}
