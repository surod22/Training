package MarsRover;

public enum Movement {
    N("N"),
    E("E"),
    S("S"),
    W("W"),
    M("M"),
    L("L"),
    R("R");

   private String identifier;

    Movement(String identifier) {


        this.identifier = identifier;
    }



    public String getValue() {
        return identifier;
    }
}

