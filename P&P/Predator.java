/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecosystem;

import java.util.ArrayList;

/**
 *
 * @author aungt
 */
public class Predator extends Actor{
    
    public void act(){
       
       if (getGrid() == null) return;
       
       ArrayList<Location> moveLocs = getMoveLocations();
       Location loc = selectMoveLocation(moveLocs);
       makeMove(loc);

        increaseCounter();
    }
    
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location>  locs = new ArrayList<>();
        
        for (Location neighborLoc : getGrid().getValidAdjacentLocations(getLocation()))
        {
            if (getGrid().get(neighborLoc)==null || getGrid().get(neighborLoc).getClass()!=this.getClass())
                locs.add(neighborLoc);
        }
        return locs;
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
