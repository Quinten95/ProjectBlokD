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
    private Muur muur;
    private boolean hasFriend;
    private Cheater cheater;
    
    private Veld rightField;
    private Veld leftField;
    private Veld upField;
    private Veld downField;
    private int cheaterID;
    
    public Veld(int x, int y, boolean isWall){
        this.x = x;
        this.y = y;
        this.isWall = isWall;
    }
    
    public void setMuur(boolean verwoestbaar){ 
        muur = new Muur();
        muur.setVerwoestbaar(verwoestbaar);
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
    
    public Veld getRightField(){
        return rightField;
    }
    
    public Veld getLeftField(){
        return leftField;
    }
    
    public Veld getUpField(){
        return upField;
    }
    
    public Veld getDownField(){
        return downField;
    }
    
    public void setHasFriend(boolean hasFriend){
        this.hasFriend = hasFriend;
    }
    
    public boolean getHasFriend(){
        return hasFriend;
    }
    
    public void setCheater(Cheater c, int id){
        this.cheaterID = id;
        this.cheater = c;
    }
    public Cheater getCheater(){
        return cheater;
    }
    
    public int getCheaterID(){
        return cheaterID;
    }
        
    public void moveItem(Item i){
        
    }
}
