package mandrews.magnificent.model;

import java.util.List;

public class Developments {

    private final List<Development> level1Developments;
    private final List<Development> level2Developments;
    private final List<Development> level3Developments;
    private final List<Long> hiddenLevel1Developments;
    private final List<Long> hiddenLevel2Developments;
    private final List<Long> hiddenLevel3Developments;

    public Developments(List<Development> level1Developments, List<Development> level2Developments,
                        List<Development> level3Developments, List<Long> hiddenLevel1Developments,
                        List<Long> hiddenLevel2Developments, List<Long> hiddenLevel3Developments) {
        this.level1Developments = level1Developments;
        this.level2Developments = level2Developments;
        this.level3Developments = level3Developments;
        this.hiddenLevel1Developments = hiddenLevel1Developments;
        this.hiddenLevel2Developments = hiddenLevel2Developments;
        this.hiddenLevel3Developments = hiddenLevel3Developments;
    }

    public List<Development> getLevel1Developments() {
        return level1Developments;
    }

    public List<Development> getLevel2Developments() {
        return level2Developments;
    }

    public List<Development> getLevel3Developments() {
        return level3Developments;
    }

    public List<Long> getHiddenLevel1Developments() {
        return hiddenLevel1Developments;
    }

    public List<Long> getHiddenLevel2Developments() {
        return hiddenLevel2Developments;
    }

    public List<Long> getHiddenLevel3Developments() {
        return hiddenLevel3Developments;
    }
}
