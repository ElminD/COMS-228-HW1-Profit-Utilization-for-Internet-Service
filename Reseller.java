package edu.iastate.cs228.hw1;

public class Reseller extends TownCell{

    public Reseller(Town p, int r, int c) {
        super(p, r, c);
    }
    //Returns the State type of cell
    @Override
    public State who() {
        return State.RESELLER;
    }

    //returns new state based on rules
    @Override
    public TownCell next(Town tNew) {

        int[] nCensus = new int[5];

        census(nCensus);

        if(nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3)
        {
            return new Empty(tNew,row,col);
        }
        if(nCensus[CASUAL] >= 5)
        {
            return new Streamer(tNew,row,col);
        }
        else {

            return new Reseller(tNew,row,col);
        }
    }
}
