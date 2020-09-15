package java3.homeworkfive.race;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {

    private ArrayList<Stage> stages;
    private Car winner; // победитель

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public synchronized Car getWinner() {
        return winner;
    }

    public synchronized void setWinner(Car winCar) {
       this.winner = winCar;
    }

    public Race(Stage... stages){
        this.stages = new ArrayList<>(Arrays.asList(stages));
        winner = null;

    }

}
