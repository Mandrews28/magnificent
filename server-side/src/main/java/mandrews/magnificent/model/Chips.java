package mandrews.magnificent.model;

import java.util.Objects;

public class Chips {
    private int black;
    private int blue;
    private int gold;
    private int green;
    private int red;
    private int white;

    public Chips() {}

    public Chips(int black, int blue, int green, int red, int white, int gold) {
        this.black = black;
        this.blue = blue;
        this.green = green;
        this.red = red;
        this.white = white;
        this.gold = gold;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chips chips = (Chips) o;
        return black == chips.black &&
                blue == chips.blue &&
                gold == chips.gold &&
                green == chips.green &&
                red == chips.red &&
                white == chips.white;
    }

    @Override
    public int hashCode() {
        return Objects.hash(black, blue, gold, green, red, white);
    }
}
