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
            MarsRover rover = new MarsRover(position[0], position[1], direction);

            String commandLine = lines[commandLineIndex];
            validateCommands(commandLine);
            executeCommand(direction, rover, commandLine);

            out += rover.getXCoordinate() + SPACE_CHARACTER + rover.getYCoordinate() + SPACE_CHARACTER + rover.getDirection() + "\n";
        }

        return out;
    }

    private void executeCommand(String direction, MarsRover rover, String commandLine) {
        for (String command : getCommandArray(commandLine)) {
            if (command.equals(M.getValue())) {
                rover.changePosition();

            } else if (command.equals(R.getValue())) {
                rover.turnRight();
            } else if (command.equals(L.getValue())) {
                rover.turnLeft();
            }
        }
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

    private String[] getCommandArray(String commandLine) {
        return commandLine.split("(?!^)");
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
