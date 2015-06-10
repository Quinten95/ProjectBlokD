/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Queue;
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

    public void zoekPad(Veld v, Queue<Veld> pad) {
        int padLengte = 0;
        
        if ((!v.getIsWall()) && (!pad.contains(v))) {
            pad.add(v);
            padLengte++;
            if(v.getHasFriend() && pad.size() < padLengte){
                
            }
        }
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
