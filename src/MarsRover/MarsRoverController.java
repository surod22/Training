package MarsRover;

import java.util.Arrays;
import java.util.List;

import static MarsRover.Movement.*;


public class MarsRoverController {


    public static final List<String> COMPASS_DIRECTIONS = Arrays.asList(N.getValue(), E.getValue(), S.getValue(), W.getValue());
    public static final List<String> VALID_COMMANDS = Arrays.asList(L.getValue(), R.getValue(), M.getValue());
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
                if (command.equals(M.getValue())) {

                    int[] newPosition = position;
                    changePosition(direction, newPosition);
                    position = newPosition;

                } else if (command.equals(R.getValue())) {
                    direction = turnRight(direction);
                } else if (command.equals(L.getValue())) {
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
            Movement.valueOf(direction).getValue().equals(direction);

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
        direction = COMPASS_DIRECTIONS.get((COMPASS_DIRECTIONS.indexOf(direction) + 3) % COMPASS_DIRECTIONS.size()).toString();
        return direction;
    }

    private String turnRight(String direction) {
        direction = COMPASS_DIRECTIONS.get((COMPASS_DIRECTIONS.indexOf(direction) + 1) % COMPASS_DIRECTIONS.size()).toString();
        return direction;
    }

    private String[] getCommandArray(String commandLine) {
        return commandLine.split("(?!^)");
    }

    private void changePosition(String direction, int[] newPosition) {
        if (direction.equals(N.getValue())) {
            newPosition[1] += +1;
        } else if (direction.equals(S.getValue())) {
            newPosition[1] += -1;
        } else if (direction.equals(E.getValue())) {
            newPosition[0] += +1;
        } else if (direction.equals(W.getValue())) {
            newPosition[0] += -1;
        }
    }

    private void validateCommands(String line) {
        for (String command : getCommandArray(line)) {
            try{
                VALID_COMMANDS.contains(command);
            }catch (RuntimeException e) {
                throw new IllegalArgumentException("Invalid command sequence: " + line);
            }
        }
    }

    public static void main(String[] args) {
         new MarsRoverController().run("5 5\n" +
                 "1 2 N\n" +
                 "LMLMLMLMM\n" +
                 "3 3 E\n" +
                 "MMRMMRMRRM");

    }

}
