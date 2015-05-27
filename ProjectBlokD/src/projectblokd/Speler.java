/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Quinten
 */
public class Speler extends Item {
    private int stappen;
    private int ammo;
    
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
