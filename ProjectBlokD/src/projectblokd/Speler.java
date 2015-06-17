/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Quinten
 */
public class Speler extends Item {

    private int stappen = 0;
    private int ammo = 0;
    private static int x;
    private static int y;
    private Veld myField;
    private int level;
    private String lastDirection;

    public BufferedImage setImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResource(path));
        } catch (Exception e) {
            System.out.println(e);
        }
        return image;
    }

    public void setMyField(Veld v) {
        myField = v;
    }

    public Veld getMyField() {
        return myField;
    }


    private void checkForItem() {
        
            if (this.getMyField().getItem() instanceof Bazooka) {
                if (this.getMyField().getBazooka().getActivated() == false) {
                    this.getMyField().getBazooka().setActivated();
                    this.ammo++;
                }
            }
            
            if (this.getMyField().getItem() instanceof Helper) {
                if (this.getMyField().getHelper().getActivated() == false) {
                    this.getMyField().getHelper().setActivated();
                }
            }
            
            if (this.getMyField().getItem() instanceof Cheater) {
                if (this.getMyField().getCheater().getActivated() == false) {
                    this.getMyField().getCheater().setActivated();
                    this.stappen = this.stappen + 4;
                }
            }
        
    }
    
    public void move(String richting){
        if(this.getMyField().getBuur(richting).getIsWall() == false){
            setMyField(myField.getBuur(richting));
            this.stappen++;
            checkForItem();
        }

    }


    public int getLevel() {
        return level;
    }

    public int getStappen() {
        return stappen;
    }

    public void setStappen(int stappen) {
        this.stappen = stappen;
    }

    public String getLastDirection() {
        return lastDirection;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setLastDirection(String direction) {
        this.lastDirection = direction;
    }
}
