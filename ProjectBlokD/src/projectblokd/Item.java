/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Quinten
 */
public class Item{
    private Cheater cheater;
    private Helper helper;
    private Bazooka bazooka;
    
    public Cheater getNewCheater(){
        cheater = new Cheater();
        return cheater;        
    }
    
    public Bazooka getNewBazooka(){
        bazooka = new Bazooka();
        return bazooka;
    }
    
    public Helper getNewHelper(){
        helper = new Helper();
        return helper;
    }
}
