import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mwittman
 * Date: 13/11/13
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class MarsRoverPositionDirectionTest {
    public static final String NORTH = "N";

    @Test
    public void shouldHavePosition() {
        MarsRoverPositionDirection marsRoverPositionDirection = new MarsRoverPositionDirection(1,1, NORTH);
        assertEquals(1,marsRoverPositionDirection.getXCoordinate());
        assertEquals(1,marsRoverPositionDirection.getYCoordinate());

    }

    @Test
    public void shouldHaveDirection() throws Exception {
        MarsRoverPositionDirection marsRoverPositionDirection = new MarsRoverPositionDirection(0,1, NORTH);
        assertEquals(NORTH, marsRoverPositionDirection.getDirection());

    }
}
