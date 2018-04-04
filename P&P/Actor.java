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

public class Actor {
    
    private Grid<Actor> grid;
    private Location location;
    private int counter;
    private int hunger;
    
    public Actor()
    {
        grid = null;
        location = null;
        counter=0;
    }
    
    public Actor(Grid<Actor> gridworld){
        grid = gridworld;
        location = null;
        counter=0;
    }
   
    public Grid<Actor> getGrid()
    {
        return grid;
    }

    public Location getLocation()
    {
        return location;
    }

    public int getCounter(){
        return counter;
    }
    
    public void increaseCounter(){
        counter++;
    }
    
    public void resetCounter(){
        counter=0;
    }
    
    public int getHunger(){
        return hunger;
    }
    
    public void increaseHunger(){
        hunger++;
    }
    
    public void resetHunger(){
        hunger=0;
    }
    
    public void putSelfInGrid(Grid<Actor> gr, Location loc)
    {
        if (grid != null)
            throw new IllegalStateException(
                    "This actor is already contained in a grid.");

        Actor actor = gr.get(loc);
        if (actor != null)
            actor.removeSelfFromGrid();
        gr.put(loc, this);
        grid = gr;
        location = loc;
    }

    public void removeSelfFromGrid()
    {
        if (grid == null)
            throw new IllegalStateException(
                    "This actor is not contained in a grid.");
        if (grid.get(location) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + location + ".");

        grid.remove(location);
        grid = null;
        location = null;
    }
    public void act(){
        return;
    }
    public void moveTo(Location newLocation)
    {
        if (grid == null)
            throw new IllegalStateException("This actor is not in a grid.");
        if (grid.get(location) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + location + ".");
        if (!grid.isValid(newLocation))
            throw new IllegalArgumentException("Location " + newLocation
                    + " is not valid.");

        if (newLocation.equals(location))
            return;
        grid.remove(location);
        Actor other = grid.get(newLocation);
        if (other != null)
            other.removeSelfFromGrid();
        location = newLocation;
        grid.put(location, this);
    }

    public String toString()
    {
        return getClass().getName() + "[location=" + location + "]";
    }
    
    public ArrayList<Location> getMoveLocations(){
        ArrayList<Location> moveLocs = new ArrayList<>();
        return(moveLocs);
    }
    
    public Location selectMoveLocation(ArrayList<Location> locs){
        Location loc = new Location(0,0);
        return(loc);
    }
    
    public ArrayList<Location> getEmptyLocations(){      
        return getGrid().getEmptyAdjacentLocations(getLocation());   
    }
    
    public void makeMove(Location loc){
        return;
    }
    
}
