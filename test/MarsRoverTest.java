import MarsRover.MarsRover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {
    public static final String NORTH = "N";
    private MarsRover rover;

    @Before
    public void setUp() throws Exception {
        rover = new MarsRover(1,1, NORTH);

    }

    @Test
    public void shouldHavePosition() {
        rover.changePosition(NORTH);
        assertEquals(1, rover.getXCoordinate());
        assertEquals(2, rover.getYCoordinate());

    }

    @Test
    public void shouldHaveDirection() throws Exception {

        assertEquals(NORTH, rover.getDirection());

    }

    @Test
    public void shouldChangePosition() throws Exception {
        rover.changePosition("E");
        assertEquals(2, rover.getXCoordinate());
    }

}
