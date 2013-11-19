import java.util.Arrays;
import java.util.List;

public class MarsRoverController {

    public static final String NORTH = "N";
    public static final String EAST = "E";
    public static final String SOUTH = "S";
    public static final String WEST = "W";
    public static final List<String> COMPASS_DIRECTIONS = Arrays.asList(NORTH, EAST, SOUTH, WEST);
    public static final String MOVE = "M";
    public static final String LEFT = "L";
    public static final String RIGHT = "R";
    public static final List<String> VALID_COMMANDS = Arrays.asList(LEFT, RIGHT, MOVE);
    public static final String SPACE_CHARACTER = " ";

    public String run(String input) {
        String out = "";

        String[] lines = input.split("\n");

        int numberOfRovers = (lines.length - 1) / 2;

        for (int i = 0; i < numberOfRovers; i++) {
            int positionLineIndex = i * 2 + 1;
            int commandLineIndex = positionLineIndex + 1;

            int []position = readRoverPosition(lines[positionLineIndex]);
            String direction = readRoverDirection(lines[positionLineIndex]);


            String commandLine = lines[commandLineIndex];

            validateCommands(commandLine);

            for (String command : getCommandArray(commandLine)) {
                if (command.equals(MOVE)) {
                    int[] newPosition = position;

                    changePosition(direction, newPosition);

                    position = newPosition;
                } else if (command.equals(RIGHT)) {
                    direction = turnRight(direction);
                } else if (command.equals(LEFT)) {
                    direction = turnLeft(direction);
                }
            }

            out += position[0] + SPACE_CHARACTER + position[1] + SPACE_CHARACTER + direction + "\n";
        }

        return out;
    }

    private String readRoverDirection(String line) {
        String direction;
        try {
            direction = line.split(SPACE_CHARACTER)[2];
            if (!Arrays.asList(NORTH, EAST, SOUTH, WEST).contains(direction)) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Could not parse direction from: " + line);
        }
        return direction;
    }

    private int[] readRoverPosition(String line) {
        try {
            String[] split = line.split(SPACE_CHARACTER);

            return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Could not parse position from: " + line);
        }
    }

    private String turnLeft(String direction) {
        direction = COMPASS_DIRECTIONS.get((COMPASS_DIRECTIONS.indexOf(direction) + 3) % COMPASS_DIRECTIONS.size());
        return direction;
    }

    private String turnRight(String direction) {
        direction = COMPASS_DIRECTIONS.get((COMPASS_DIRECTIONS.indexOf(direction) + 1) % COMPASS_DIRECTIONS.size());
        return direction;
    }

    private String[] getCommandArray(String commandLine) {
        return commandLine.split("(?!^)");
    }

    private void changePosition(String direction, int[] newPosition) {
        if (direction.equals(NORTH)) {
            newPosition[1] += +1;
        } else if (direction.equals(SOUTH)) {
            newPosition[1] += -1;
        } else if (direction.equals(EAST)) {
            newPosition[0] += +1;
        } else if (direction.equals(WEST)) {
            newPosition[0] += -1;
        }
    }

    private void validateCommands(String line) {
        for (String command : getCommandArray(line)) {
            if (!VALID_COMMANDS.contains(command)) {
                throw new IllegalArgumentException("Invalid command sequence: " + line);
            }
        }
    }

}
