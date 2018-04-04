/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aungt
 */

import java.util.*;

public class Ecosystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter length of grid");
        int col = inp.nextInt();
        System.out.println("Enter width of grid");
        int row = inp.nextInt();
        
        System.out.println("Enter number of preys");
        int py = inp.nextInt();
        System.out.println("Enter number of predators");
        int pd = inp.nextInt();
        
        Predator pred = new Predator(); Prey prey= new Prey();
        Grid<Actor> world = new Grid(row , col);
        Random random = new Random();
        
        ArrayList<Actor> animal = new ArrayList<>();
        int i; 
        Location loc; boolean check=false;
        
        for(i=0; i<py; i++){
            check=false;
            while(!check){ 
                loc = new Location( random.nextInt(row), random.nextInt(col));
                if(world.get(loc)==null){
                    animal.add(new Prey());
                    check=true;
                    animal.get(i).putSelfInGrid(world, loc);
                }        
            }    
        }
        
        for(i=py; i<py+pd; i++){
            check=false;
            while(!check){
                loc = new Location( random.nextInt(row), random.nextInt(col));
                if(world.get(loc)==null){
                    animal.add(new Predator());
                    check=true;
                    animal.get(i).putSelfInGrid(world, loc);
                }    
            }
        }
       
        ArrayList<Location> moveLocs;
        boolean cont=true; int turn=0; int count=0;
        int move=1;
        int index=0; 

        while(cont){
            
            Collections.shuffle(animal);
            
            for(i=0; i<animal.size(); i++){
               
               if(animal.get(i).getClass()== pred.getClass()){
                   if(animal.get(i).getHunger()==5){
                       animal.remove(i).removeSelfFromGrid();
                       pd--;
                   }
                   else if(animal.get(i).getCounter()==8){
                       moveLocs = animal.get(i).getMoveLocations();
                       if(!moveLocs.isEmpty()){
                            loc = animal.get(i).selectMoveLocation(moveLocs);
                            if(world.get(loc)!=null && world.get(loc).getClass()==prey.getClass()){
                                index = animal.indexOf(world.get(loc));
                                if(index<i) i--;
                                animal.remove(index).removeSelfFromGrid();
                                py--;
                            }
                            animal.add(new Predator());
                            animal.get(animal.size()-1).putSelfInGrid(world, loc);
                            pd++;
                            animal.get(i).resetCounter();
                       }
                       
                       moveLocs = animal.get(i).getMoveLocations();
                       loc = animal.get(i).selectMoveLocation(moveLocs);
                       animal.get(i).increaseHunger();
                       if(world.get(loc)!=null && world.get(loc).getClass()==prey.getClass()){
                           index = animal.indexOf(world.get(loc));
                           if(index<i) i--;
                           animal.remove(index).removeSelfFromGrid();
                           py--;
                           animal.get(i).resetHunger();
                       }
                       animal.get(i).makeMove(loc);
                       animal.get(i).increaseCounter();
                   }
                   else{
                       moveLocs = animal.get(i).getMoveLocations();
                       loc = animal.get(i).selectMoveLocation(moveLocs);
                       animal.get(i).increaseHunger();
                       if(world.get(loc)!=null && world.get(loc).getClass()==prey.getClass()){
                           index = animal.indexOf(world.get(loc));
                           if(index<i) i--;
                           animal.remove(index).removeSelfFromGrid();
                           py--;
                           animal.get(i).resetHunger();
                       }
                       animal.get(i).makeMove(loc);
                       animal.get(i).increaseCounter();
                   }
               }
               
               else{
                   if(animal.get(i).getCounter()==3){
                       moveLocs = animal.get(i).getMoveLocations();
                       if(!moveLocs.isEmpty()){
                            loc = animal.get(i).selectMoveLocation(moveLocs);
                            animal.add(new Prey());
                            animal.get(animal.size()-1).putSelfInGrid(world, loc);
                            py++;
                       }     
                       animal.get(i).resetCounter();
                       animal.get(i).act();
                   }
                   else{
                       animal.get(i).act();
                   }
               }   
            }
            turn++; count++; 
            if(count==move){
                System.out.println("turn "+ turn);
                System.out.println(world);
                System.out.println(pd+" Predators");
                System.out.println(py+" Preys");
                System.out.println("");
                count=0; 
                System.out.println("Enter additional number of moves, -1 to stop");
                move = inp.nextInt();
                if(move==-1)
                    cont=false; 
            }
        }
        
    }
    
}
