/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Stack;
import javax.imageio.ImageIO;

/**
 *
 * @author Quinten
 */
public class Helper extends Item {

    private boolean activated = false;
    private Veld myField;
    private int x;
    private int y;
    
    private Stack<Veld> kortstePad = new Stack<>();
    private int padLengte = Integer.MAX_VALUE;
    public static enum Richting{
        up, down, right, left
    }

    private void zoekPad(Veld v, Stack<Veld> pad) {
        if ((!v.getIsWall()) && (!pad.contains(v))) {
            pad.push(v);
            padLengte++;
            if(v.getHasFriend() && pad.size() < padLengte){
                kortstePad = (Stack<Veld>) pad.clone();
                padLengte = pad.size();
            }
            else{
                for(Richting richting : Richting.values()){
                    zoekPad(v.getBuur(richting.toString()), pad);
                }
            }
        }
    }
    
    public Stack getKorstePad(Veld v){
        zoekPad(v, kortstePad);        
        return kortstePad;
    }
    
    public void setMyField(Veld v) {
        this.myField = v;
        setX();
        setY();
    }

    public Veld getMyField() {
        return myField;
    }

    private void setX() {
        this.x = myField.getX();
    }

    private void setY() {
        this.y = myField.getY();
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
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
