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
    
    public Veld(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Veld getFieldAt(int x, int y){
        return new Veld(x, y);
    }
    
    public void moveItem(Item i){
        
    }
}
