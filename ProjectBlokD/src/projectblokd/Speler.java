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
    private ArrayList<Veld> maze1Fields = new ArrayList<>();
    
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
    public void setMaze1Fields(ArrayList fields){
        maze1Fields = fields;
    }
    
    public void moveLeft(){
        Veld myField = new Veld(x, y, false);
        Veld leftField = myField.getMaze1FieldAt(x - 35, y);
        
        if(leftField.getIsWall() == false){
            x = x - 35;
        }
    }
    
    public void moveRight(){
        Veld myField = new Veld(x, y, false);
        Veld rightField = myField.getMaze1FieldAt(x + 35, y);
        
        if(rightField.getIsWall() == false){
            x = x + 35;
        }        
    }
    
    public void moveDown(){
        Veld myField = new Veld(x, y, false);
        Veld downField = myField.getMaze1FieldAt(x, y + 35);
        
        if(downField.getIsWall() == false){
            y = y + 35;
        }       
    }
    
    public void moveUp(){
        Veld myField = new Veld(x, y, false);
        Veld upField = myField.getMaze1FieldAt(x, y - 35);
        
        if(upField.getIsWall() == false){
            y = y - 35;
        }       
    }
}
