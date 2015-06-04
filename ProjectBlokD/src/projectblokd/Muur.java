/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Quinten
 */
public class Muur extends Item{
    private boolean verwoestbaar;     
    
    public void setVerwoestbaar(boolean verwoestbaar){
        this.verwoestbaar = verwoestbaar;
    }
    public boolean getVerwoestbaar(){
        return verwoestbaar;
    }
    
    
}
