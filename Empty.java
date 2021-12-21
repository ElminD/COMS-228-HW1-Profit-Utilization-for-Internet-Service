package edu.iastate.cs228.hw1;

public class Empty extends TownCell{
    public Empty(Town p, int r, int c) {
        super(p, r, c);
    }

    //Returns the State type of cell
    @Override
    public State who() {
        return State.EMPTY;
    }

    //change based on rules
    @Override
    public TownCell next(Town tNew) {

        int[] nCensus = new int[5];

        census(nCensus);

        if(nCensus[OUTAGE] + nCensus[EMPTY] <= 1){
            return new Reseller(tNew,row,col);
        }
        return new Casual(tNew,row,col);
    }
}
