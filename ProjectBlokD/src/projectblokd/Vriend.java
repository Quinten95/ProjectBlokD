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
public class Vriend extends Item{
    private static int x;
    private static int y;
    private Veld myField;
    
    public void setMyField(Veld v) {
        myField = v;
        setX();
        setY();
    }
    
    public void setX() {
        Vriend.x = myField.getX();
    }

    public void setY() {
        Vriend.y = myField.getY();
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public BufferedImage setImage(String path){
        BufferedImage image = null;
        try{
            image = ImageIO.read(this.getClass().getResource(path));
        }
        catch(Exception e){
            System.out.println(e);
        }
        return image;
    }
    
}
