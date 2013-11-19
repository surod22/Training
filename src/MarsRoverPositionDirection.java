/**
 * Created with IntelliJ IDEA.
 * User: mwittman
 * Date: 13/11/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class MarsRoverPositionDirection {

    private int xCoordinate;
    private int yCoordinate;
    private String direction;

    public MarsRoverPositionDirection(int xCoordinate, int yCoordinate, String direction) {
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
}
