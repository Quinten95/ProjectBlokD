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
    
    private Veld rightField;
    private Veld leftField;
    private Veld upField;
    private Veld downField;
    
    public Veld(int x, int y, boolean isWall){
        this.x = x;
        this.y = y;
        this.isWall = isWall;
    }
    
    public void setRightField(Veld v){
        this.rightField = v;
    }
    
    public void setLeftField(Veld v){
        this.leftField = v;
    }
    
    public void setUpField(Veld v){
       this.upField = v;
    }
    
    public void setDownField(Veld v){
        this.downField = v;
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
