/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 *
 * @author Quinten
 */
public class Doolhof extends JComponent{
    Muur muur = new Muur();
    Speler speler = new Speler();
    private Image spelerImage;
    private int spelerX = 36;
    private int spelerY = 38;
    
    ArrayList<Veld> maze1Walls = new ArrayList<>();
    
    public void init(){
        muur.fillMaze1();
        maze1Walls = muur.getMaze1();
        spelerImage = speler.setImage("/images/MainCharacterRight.png");
        
    }
    public void paintWalls(){
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        for(Veld v : maze1Walls){
            int x = v.getX();
            int y = v.getY();
            g.fillRect(x, y, 35, 35);
        }
        g.drawImage(spelerImage, spelerX, spelerY, 30, 30, this);
    } 
    
    public void moveCharacterLeft(){
        spelerX = spelerX - 35;
        spelerImage = speler.setImage("/images/MainCharacterLeft.png");
        repaint();
    }
    
    public void moveCharacterRight(){
        spelerX = spelerX + 35;
        spelerImage = speler.setImage("/images/MainCharacterRight.png");
        repaint();
    }
    
    public void moveCharacterDown(){
        spelerY = spelerY + 35;
        spelerImage = speler.setImage("/images/MainCharacterDown.png");
        repaint();
    }
    
    public void moveCharacterUp(){
        spelerY = spelerY - 35;
        spelerImage = speler.setImage("/images/MainCharacterUp.png");
        repaint();
    }
    
}


