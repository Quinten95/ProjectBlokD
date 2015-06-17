/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import java.util.Stack;
import javax.imageio.ImageIO;

/**
 *
 * @author Quinten
 */
public class Helper extends Item {

    private boolean activated = false;
    private Veld myField;
    
    private Stack<Veld> kortstePad = new Stack<>();
    private int padLengte = Integer.MAX_VALUE;
    public static enum Richting{
        up, right, down, left
    }

    private void zoekPad(Veld v, Stack<Veld> pad) {
        if((!v.getIsWall()) && (!pad.contains(v))) {
            pad.push(v);
            if(v.getHasFriend()){
                if (pad.size() < padLengte){
                    kortstePad = (Stack<Veld>) pad.clone();
                    padLengte = pad.size();
                }
            }
            else{
                for(Richting richting : Richting.values()){
                    zoekPad(v.getNeighbourField(richting.toString()), pad); 
                }
            }
            pad.pop();
        }
        
    }
    
    public Stack getKorstePad(Veld v){       
        zoekPad(v, kortstePad);        
        return kortstePad;
    }
    
    public void setMyField(Veld v) {
        this.myField = v;
    }

    public Veld getMyField() {
        return myField;
    }

    public BufferedImage setImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResource(path));
        } catch (Exception e) {
            System.out.println(e);
        }
        return image;
    }

    public void setActivated() {
        this.activated = true;
    }

    public boolean getActivated() {
        return activated;
    }
}
