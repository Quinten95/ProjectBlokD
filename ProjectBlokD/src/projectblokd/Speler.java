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
    
    public void setMyField(Veld v){
        myField = v;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        Speler.x = x;
    }
    public void setY(int y){
        Speler.y = y;
    }
    
    public void moveLeft(){
       
    }
    
    public void moveRight(){
              
    }
    
    public void moveDown(){
             
    }
    
    public void moveUp(){
              
    }
}
