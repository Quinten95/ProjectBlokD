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

    private int stappen;
    private int ammo;
    private static int x;
    private static int y;
    private Veld myField;

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

    public void moveLeft() {
        setMyField(myField.getLeftField());
    }

    public void moveRight() {
        setMyField(myField.getRightField());
    }

    public void moveDown() {
        setMyField(myField.getDownField());
    }

    public void moveUp() {
        setMyField(myField.getUpField());
    }
}
