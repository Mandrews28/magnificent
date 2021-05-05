package mandrews.magnificent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noble")
public class Noble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @NonNull
    private int influencePoints;

    @NonNull
    private int costBlack;

    @NonNull
    private int costBlue;

    @NonNull
    private int costGreen;

    @NonNull
    private int costRed;

    @NonNull
    private int costWhite;

    public Noble(int influencePoints, int costBlack, int costBlue, int costGreen, int costRed, int costWhite) {
        this.influencePoints = influencePoints;
        this.costBlack = costBlack;
        this.costBlue = costBlue;
        this.costGreen = costGreen;
        this.costRed = costRed;
        this.costWhite = costWhite;
    }

    public Noble() {}

    public int getInfluencePoints() {
        return influencePoints;
    }

    public int getCostBlack() {
        return costBlack;
    }

    public int getCostBlue() {
        return costBlue;
    }

    public int getCostGreen() {
        return costGreen;
    }

    public int getCostRed() {
        return costRed;
    }

    public int getCostWhite() {
        return costWhite;
    }
}
