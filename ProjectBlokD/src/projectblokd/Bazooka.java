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
public class Bazooka extends Item {

    private boolean activated = false;
    private Veld myField;
    private String lastDirection;

    public void setMyField(Veld v) {
        this.myField = v;
    }

    public Veld getMyField() {
        return myField;
    }

    public void fireBazooka(String direction) {
        this.lastDirection = direction;
        switch (lastDirection) {
            case "left":
                while (getMyField().getLeftField().getIsWall() == false) {
                    setMyField(getMyField().getLeftField());
                }
                if (getMyField().getLeftField().getMuur().getVerwoestbaar()) {
                    getMyField().getLeftField().setIsWall(false);
                }
                break;
                
            case "right":
                while (getMyField().getRightField().getIsWall() == false) {
                    setMyField(getMyField().getRightField());
                }
                if (getMyField().getRightField().getMuur().getVerwoestbaar()) {
                    getMyField().getRightField().setIsWall(false);
                }
                break;
                
            case "up":
                while (getMyField().getUpField().getIsWall() == false) {
                    setMyField(getMyField().getUpField());
                }
                if (getMyField().getUpField().getMuur().getVerwoestbaar()) {
                    getMyField().getUpField().setIsWall(false);
                }
                break;
                
            case "down":
                while (getMyField().getDownField().getIsWall() == false) {
                    setMyField(getMyField().getDownField());
                }
                if (getMyField().getDownField().getMuur().getVerwoestbaar()) {
                    getMyField().getDownField().setIsWall(false);
                }
                break;
        }
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
