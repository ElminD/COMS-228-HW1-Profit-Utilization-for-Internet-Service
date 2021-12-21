package edu.iastate.cs228.hw1;

import java.net.SocketOption;
import java.util.stream.Stream;

public class Casual extends TownCell{
    public Casual(Town p, int r, int c) {
        super(p, r, c);
    }

    //Returns the State type of cell
    @Override
    public State who() {
        return State.CASUAL;
    }

    //checks what it changes to based on rules
    @Override
    public TownCell next(Town tNew) {

        int[] nCensus = new int[5];

        census(nCensus);

        if(nCensus[OUTAGE] + nCensus[EMPTY] <= 1){
            return new Reseller(tNew,row,col);
        }
        else if(nCensus[RESELLER] > 0)
        {
            return new Outage(tNew,row,col);
        }
        else if(nCensus[STREAMER] > 0 || nCensus[CASUAL] >= 5)
        {
            return new Streamer(tNew,row,col);
        }
        else
        {
            return new Casual(tNew,row,col);
        }



    }
}
