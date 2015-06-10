/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
    private int itemID;
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
        setX();
        setY();
    }

    public Veld getMyField() {
        return myField;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX() {
        Speler.x = myField.getX();
    }

    public void setY() {
        Speler.y = myField.getY();
    }

    private int checkForCheater() {
        try {
            if (this.getMyField().getCheater().getActivated() == false) {
                itemID = this.getMyField().getItemID();
                return itemID;
            } else {
                return -1;
            }
        } catch (NullPointerException e) {
            return -1;
        }
    }

    private int checkForBazooka() {
        try {
            if (this.getMyField().getBazooka().getActivated() == false) {
                itemID = this.getMyField().getItemID();
                return itemID;
            } else {
                return -1;
            }
        } catch (NullPointerException e) {
            return -1;
        }
    }
    
    private int checkForHelper() {
        try {
            if (this.getMyField().getHelper().getActivated() == false) {
                itemID = this.getMyField().getItemID();
                return itemID;
            } else {
                return -1;
            }
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public int moveLeft() {
        setMyField(myField.getLeftField());
        
        this.stappen++;
        if (checkForCheater() > 0) {
            this.stappen = this.stappen + 4;
            return checkForCheater();
        }
        if (checkForBazooka() > 0) {
            this.ammo++;
            return checkForBazooka();
        }
        if (checkForHelper() > 0) {
            return checkForHelper();
        }
        return -1;
    }

    public int moveRight() {
        setMyField(myField.getRightField());
        
        this.stappen++;
        if (checkForCheater() > 0) {
            this.stappen = this.stappen + 4;
            return checkForCheater();
        }
        if (checkForBazooka() > 0) {
            this.ammo++;
            return checkForBazooka();
        }
        if (checkForHelper() > 0) {
            return checkForHelper();
        }
        return -1;
    }

    public int moveDown() {
        setMyField(myField.getDownField());
        
        this.stappen++;
        if (checkForCheater() > 0) {
            this.stappen = this.stappen + 4;
            return checkForCheater();
        }
        if (checkForBazooka() > 0) {
            this.ammo++;
            return checkForBazooka();
        }
        if (checkForHelper() > 0) {
            return checkForHelper();
        }
        return -1;
    }

    public int moveUp() {
        setMyField(myField.getUpField());
       
        this.stappen++;
        if (checkForCheater() > 0) {
            this.stappen = this.stappen + 4;
            return checkForCheater();
        }
        if (checkForBazooka() > 0) {
            this.ammo++;
            return checkForBazooka();
        }
        if (checkForHelper() > 0) {
            return checkForHelper();
        }
        return -1;
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
    
    public void setLastDirection(String direction){
        this.lastDirection = direction;
    }
}
