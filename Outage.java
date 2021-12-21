package edu.iastate.cs228.hw1;

public class Outage extends TownCell {
    public Outage(Town p, int r, int c) {
        super(p, r, c);
    }

    //Returns the State type of cell
    @Override
    public State who() {
        return State.OUTAGE;
    }

    //return empty based on rules
    @Override
    public TownCell next(Town tNew) {



        return new Empty(tNew,row,col);
    }
}
