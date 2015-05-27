/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Quinten
 */
public class Speler extends Item {
    private int stappen;
    private int ammo;
    private Image playerImage;
    
    public void loadImage(){
        playerImage = new ImageIcon("images/MainCharacter.png").getImage();
    }
    
}
