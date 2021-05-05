package mandrews.magnificent.model;

import java.util.List;

public class Player {
    private String name;
    private int gameOrder;
    private int influencePoints;
    private List<Development> developments;
    private List<Development> hiddenDevelopments;
    private List<Noble> nobles;
    private Chips chips;

    public Player() {}

    public Player(String name, int gameOrder, int influencePoints, List<Development> developments,
                  List<Development> hiddenDevelopments, List<Noble> nobles, Chips chips) {
        this.name = name;
        this.gameOrder = gameOrder;
        this.influencePoints = influencePoints;
        this.developments = developments;
        this.hiddenDevelopments = hiddenDevelopments;
        this.nobles = nobles;
        this.chips = chips;
    }

    public String getName() {
        return name;
    }

    public int getGameOrder() {
        return gameOrder;
    }

    public int getInfluencePoints() {
        return influencePoints;
    }

    public void setInfluencePoints(int influencePoints) {
        this.influencePoints = influencePoints;
    }

    public List<Development> getDevelopments() {
        return developments;
    }

//    public void setDevelopments(List<Development> developments) {
//        this.developments = developments;
//    }

    public List<Development> getHiddenDevelopments() {
        return hiddenDevelopments;
    }

//    public void setHiddenDevelopments(List<Development> hiddenDevelopments) {
//        this.hiddenDevelopments = hiddenDevelopments;
//    }

    public List<Noble> getNobles() {
        return nobles;
    }

//    public void setNobles(List<Noble> nobles) {
//        this.nobles = nobles;
//    }

    public Chips getChips() {
        return chips;
    }

//    public void setChips(Chips chips) {
//        this.chips = chips;
//    }
}
