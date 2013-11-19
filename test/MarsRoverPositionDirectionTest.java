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
    @Test
    public void shouldHavePosition() {
        MarsRoverPositionDirection marsRoverPositionDirection = new MarsRoverPositionDirection(0,1);
        assertEquals(0,marsRoverPositionDirection.getX());

    }


}
