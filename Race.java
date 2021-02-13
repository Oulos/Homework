package HW_5;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {

    private ArrayList<Stage> stages;
    private boolean isThereWinner = false;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public boolean getWinner() {
        return isThereWinner;
    }

    public void setWinner() {
        this.isThereWinner = true;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

}
