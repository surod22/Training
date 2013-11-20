import MarsRover.MarsRoverController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverControllerTest {

    private MarsRoverController roverController;

    @Before
    public void setUp() throws Exception {
        roverController = new MarsRoverController();
    }

    @Test
    public void shouldMoveRoverAround() throws Exception {
        assertEquals("1 3 N\n", roverController.run("5 5\n" + "1 1 N\n" + "MM\n"));
    }

    @Test
    public void shouldTurnRoverRight() throws Exception {
        assertEquals("1 1 W\n", roverController.run("5 5\n" +
                "" + "1 1 N\n" + "RRR\n"));
    }

    @Test
    public void shouldTurnRoverLeft() throws Exception {
        assertEquals("1 1 E\n", roverController.run("5 5\n" + "1 1 N\n" + "LLL\n"));
    }


    @Test
    public void shouldMoveMultipleRoversCorrectly() throws Exception {
        String in = "5 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM";

        assertEquals("1 3 N\n5 1 E\n", roverController.run(in));
    }




}
