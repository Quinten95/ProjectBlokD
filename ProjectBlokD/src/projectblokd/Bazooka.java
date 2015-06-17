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

    public void setMyField(Veld v) {
        this.myField = v;
    }

    public Veld getMyField() {
        return myField;
    }

    public void fireBazooka(String direction) {

        while (getMyField().getNeighbourField(direction).getIsWall() == false) {
            setMyField(getMyField().getNeighbourField(direction));
        }
        if (getMyField().getNeighbourField(direction).getMuur().getVerwoestbaar()) {
            getMyField().getNeighbourField(direction).setIsWall(false);
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
