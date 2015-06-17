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
    
    private Veld myField;
    
    public void setMyField(Veld v) {
        myField = v;
    }
    
    public Veld getMyField(){
        return myField;
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
