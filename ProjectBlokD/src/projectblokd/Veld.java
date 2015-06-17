/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

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
    private Bazooka bazooka;
    private Helper helper;
    
    private Item item;
    
    private Veld rightField;
    private Veld leftField;
    private Veld upField;
    private Veld downField;
    
    public Veld(int x, int y, boolean isWall){
        this.x = x;
        this.y = y;
        this.isWall = isWall;
        
    }
    
    public void setMuur(boolean verwoestbaar){ 
        muur = new Muur();
        muur.setVerwoestbaar(verwoestbaar);
    }
    public Muur getMuur(){
        return muur;
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
    
    public void setIsWall(boolean isWall){
        this.isWall = isWall;
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
    
    public Veld getBuur(String richting){
        switch(richting){
            case "up":
                return upField;
            case "down":
                return downField;
            case "left":
                return leftField;
            case "right":
                return rightField;
        }
        return this;
    }
    
    
    public void setHasFriend(boolean hasFriend){
        this.hasFriend = hasFriend;
    }
    
    public boolean getHasFriend(){
        return hasFriend;
    }
    
    public Cheater getCheater(){
        return cheater;
    }
    
    public Bazooka getBazooka(){
        return bazooka;
    }
    
    public Helper getHelper(){
        return helper;
    }
    
    public Item getItem(){
        return item;
    }
    
    public void setItem(Item i){
        this.item = i;
        
        if(i instanceof Cheater){
            this.cheater = (Cheater) i;
        }
        if(i instanceof Bazooka){
            this.bazooka = (Bazooka) i; 
        }
        if(i instanceof Helper){
            this.helper = (Helper) i; 
        }
    
    }
    
}
