package creatures;

import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;
import static huglife.HugLifeUtils.randomEntry;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Clorus extends Creature {
    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;
    /**
     * fraction of energy to bestow upon offspring.
     */
    private double repEnergyGiven = 0.5;
    /**
     * fraction of energy to retain when replicating.
     */
    private double repEnergyRetained = 0.5;
    /**
     * creates plip with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * creates a plip with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    public Color color() {
        r = 34;
        b = 231;
        g = 0;
        return color(r, g, b);
    }


    public void attack(Creature c) {
        energy += c.energy();
    }

    public Clorus replicate() {
        double babyEnergy = energy * repEnergyGiven;
        energy = energy * repEnergyRetained;
        return new Clorus(babyEnergy);
    }

    public void move() {
        energy -= 0.03;
    }



    public void stay() {
        energy -= 0.01;
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {

        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipsNeighbors = new ArrayDeque<>();
        boolean anyPlips = false;

        for(huglife.Direction key:neighbors.keySet()){
            if(neighbors.get(key).name().equals("empty")){
                emptyNeighbors.add(key);
            }
            if(neighbors.get(key).name().equals("plip")){
                plipsNeighbors.add(key);
                anyPlips = true;
            }
        }

        if (emptyNeighbors.size() == 0) {
            return new Action(Action.ActionType.STAY);
        }
        if(anyPlips){
            return new Action(Action.ActionType.ATTACK, randomEntry(plipsNeighbors));
        }
        if(energy >= 1){
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));

        }
        return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
    }


}
