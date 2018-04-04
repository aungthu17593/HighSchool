/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author aungt
 */
public class Prey extends Actor{
  
    public void act(){
       
       if (getGrid() == null) return;
       
       ArrayList<Location> moveLocs = getMoveLocations();
       Location loc = selectMoveLocation(moveLocs);
       makeMove(loc);

       increaseCounter();
    }
    
     public ArrayList<Location> getMoveLocations()
    {
        return getGrid().getEmptyAdjacentLocations(getLocation()); 
    }
     
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        if (n == 0)
            return getLocation();
        int r = (int) (Math.random() * n);
        return locs.get(r);
    } 
       
    public void makeMove(Location loc)
    {
        if (loc == null)
            removeSelfFromGrid();
        else
            moveTo(loc);
    }
}
