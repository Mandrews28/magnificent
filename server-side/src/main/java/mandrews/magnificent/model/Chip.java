package mandrews.magnificent.model;

public enum Chip {
    BLACK("black"),
    BLUE("blue"),
    GOLD("gold"),
    GREEN("green"),
    RED("red"),
    WHITE("white"),
    UNKNOWN("unknown");

    private final String colour;

    Chip(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public static Chip get(String colour) {
        if (colour != null) {
            for (Chip chip : values()) {
                if (chip.getColour().equals(colour)) {
                    return chip;
                }
            }
        }
        return getDefault();
    }

    public static Chip getDefault() {
        return UNKNOWN;
    }
}
