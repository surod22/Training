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

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public Object getDirection() {

        return direction;
    }

    public void changePosition(String direction) {
        if (direction.equals(N.getValue())) {
            this.yCoordinate += +1;
        } else if (direction.equals(S.getValue())) {
            this.yCoordinate += -1;
        } else if (direction.equals(E.getValue())) {
            this.xCoordinate += +1;
        } else if (direction.equals(W.getValue())) {
            this.xCoordinate += -1;
        }


    }
}
