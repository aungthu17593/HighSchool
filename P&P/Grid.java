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
public class Grid<E>
{
    private Object[][] occupantArray;
    
    public Grid(int rows, int cols)
    {
        if (rows <=0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");
        occupantArray = new Object[rows][cols];
    }
    
    public int getNumRows()
    {
        return occupantArray.length;
    }
    
    public int getNumCols()
    {
        return occupantArray[0].length;
    }
    
    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
               && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }         
    
    //get location of valid neighboring cells.
    
    public ArrayList<Location> getValidAdjacentLocations(Location loc)
    {
        ArrayList<Location> locs = new ArrayList<>();
        Location neighborLoc;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                 neighborLoc = new Location(loc.getRow()+i, loc.getCol()+j);
                 if (isValid(neighborLoc))
                 locs.add(neighborLoc);
            }
        }
        return locs;
    }

    //get location of neighboring empty cells.
    
    public ArrayList<Location> getEmptyAdjacentLocations(Location loc)
    {
        ArrayList<Location> locs = new ArrayList<>();
        for (Location neighborLoc : getValidAdjacentLocations(loc))
        {
            if (get(neighborLoc) == null)
                locs.add(neighborLoc);
        }
        return locs;
    }
    
    public String toString()
    {
       Predator pred = new Predator(); Prey prey = new Prey();
       for(int i=0; i<occupantArray.length; i++){
           for(int j=0; j<occupantArray[0].length; j++){
               if(occupantArray[i][j]==null) 
                   System.out.print("* ");
               else{
                   if(occupantArray[i][j].getClass().equals(pred.getClass()))
                        System.out.print("X ");
                   else if(occupantArray[i][j].getClass().equals(prey.getClass()))
                        System.out.print("O ");
               }
           }
           System.out.println("");
       }
       return("");
    }
    
    // get, set remove actors.
    
    public E get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        return (E) occupantArray[loc.getRow()][loc.getCol()]; // unavoidable warning
    }

    public E put(Location loc, E obj)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");
        
        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }

    public E remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        E r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }
}
