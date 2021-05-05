package mandrews.magnificent.model;

public class Chips {
    private int black;
    private int blue;
    private int gold;
    private int green;
    private int red;
    private int white;

    public Chips() {}

    public Chips(int black, int blue, int gold, int green, int red, int white) {
        this.black = black;
        this.blue = blue;
        this.gold = gold;
        this.green = green;
        this.red = red;
        this.white = white;
    }

    public int getBlack() {
        return black;
    }

    public int getBlue() {
        return blue;
    }

    public int getGold() {
        return gold;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

    public int getWhite() {
        return white;
    }

    //need to be able to add and subtract chips from this state
}
