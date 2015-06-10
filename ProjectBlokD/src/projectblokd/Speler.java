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
    private int ammo;
    private static int x;
    private static int y;
    private Veld myField;
    private int level;
    
    private Cheater voidCheater;
    private int cheaterID;

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

    private int checkForCheater(){
        try{
            if(this.getMyField().getCheater().getActivated() == false){
                cheaterID = this.getMyField().getCheaterID();
                this.stappen = this.stappen + 5;
                return cheaterID;
            }
            else{
                return -1;
            }
         }
         catch(NullPointerException e){
             return -1;
         }
    }
    
    public int moveLeft() {
        setMyField(myField.getLeftField());
        return checkForCheater();
    }
    
    public int moveRight() {
        setMyField(myField.getRightField());
        return checkForCheater();
    }
    

    public int moveDown() {
        setMyField(myField.getDownField());
        return checkForCheater();
    }

    public int moveUp() {
        setMyField(myField.getUpField());
        return checkForCheater();
    }
    
    public int getLevel(){
        return level;
    }
    
    public int getStappen(){
        return stappen;
    }
    
    public void setStappen(int stappen){
        this.stappen = stappen;
    }
}
