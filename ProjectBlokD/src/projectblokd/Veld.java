/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.ArrayList;

/**
 *
 * @author Quinten
 */
public class Veld {
    private int x;
    private int y;
    private boolean isWall;    
    private static ArrayList<Veld> maze1Fields = new ArrayList<>();
    
    public Veld(int x, int y, boolean isWall){
        this.x = x;
        this.y = y;
        this.isWall = isWall;
    }
    
    public void fillMaze1Fields(Veld v){
        maze1Fields.add(v);
    }
    
    public ArrayList getMaze1Fields(){
        return maze1Fields;
    }
    
    public Veld getMaze1FieldAt(int x, int y){
        for(Veld v : maze1Fields){
            if(x == v.getX() && y == v.getY()){
                return v;
            }            
        }
        return null;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean getIsWall(){
        return isWall;
    }
        
    public void moveItem(Item i){
        
    }
}
