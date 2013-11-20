package MarsRover;

import static MarsRover.Movement.*;

public class MarsRover {

    private int xCoordinate;
    private int yCoordinate;
    private String direction;

    public MarsRover(int xCoordinate, int yCoordinate, String direction) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
    }

    public String turnLeft() {
        this.direction = MarsRoverController.COMPASS_DIRECTIONS.get((MarsRoverController.COMPASS_DIRECTIONS.indexOf(this.direction) + 3) % MarsRoverController.COMPASS_DIRECTIONS.size()).toString();
        return this.direction;
    }

    public String turnRight() {
        this.direction = MarsRoverController.COMPASS_DIRECTIONS.get((MarsRoverController.COMPASS_DIRECTIONS.indexOf(this.direction) + 1) % MarsRoverController.COMPASS_DIRECTIONS.size()).toString();
        return this.direction;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public Object getDirection() {

        return direction;
    }

    public void changePosition() {
        if (this.direction.equals(N.getValue())) {
            this.yCoordinate += +1;
        } else if (this.direction.equals(S.getValue())) {
            this.yCoordinate += -1;
        } else if (this.direction.equals(E.getValue())) {
            this.xCoordinate += +1;
        } else if (this.direction.equals(W.getValue())) {
            this.xCoordinate += -1;
        }


    }
}
