/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JComponent;
/**
 *
 * @author Quinten
 */
public class Doolhof extends JComponent{
    Muur muur = new Muur();
    Speler speler = new Speler();
    private Image spelerImage;
    private int spelerX;
    private int spelerY;
    
    ArrayList<Veld> maze1Walls = new ArrayList<>();
    
    public void init(){
        spelerX = 36;
        spelerY = 36;
        muur.fillMaze1();
        maze1Walls = muur.getMaze1();
        spelerImage = speler.setImage("/images/MainCharacterRight.png");
        
    }
    public void paintMaze(){
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
        boolean collision = false;
        for(Veld v : maze1Walls){
            int x = v.getX();
            if(x == (spelerX - 35)){
                int y = v.getY();
                if(y == spelerY){
                    collision = true;
                }
            }
        }
        if(collision == false){
            spelerX = spelerX - 35;
            spelerImage = speler.setImage("/images/MainCharacterLeft.png");
            repaint();
        }
        else if(collision == true){
            spelerImage = speler.setImage("/images/MainCharacterLeft.png");
            repaint();
        }
    }
    
    public void moveCharacterRight(){
        boolean collision = false;
        for(Veld v : maze1Walls){
            int x = v.getX();
            if(x == (spelerX + 35)){
                int y = v.getY();
                if(y == spelerY){
                    collision = true;
                }
            }
        }
        if(collision == false){
            spelerX = spelerX + 35;
            spelerImage = speler.setImage("/images/MainCharacterRight.png");
            repaint();
        }
        else if (collision == true){
            spelerImage = speler.setImage("/images/MainCharacterRight.png");
            repaint();
        }
    }
    
    public void moveCharacterDown(){
        boolean collision = false;
        for(Veld v : maze1Walls){
            int y = v.getY();
            if(y == (spelerY + 35)){
                int x = v.getX();
                if(x == spelerX){
                    collision = true;
                }
            }
        }
        if(collision == false){
            spelerY = spelerY + 35;
            spelerImage = speler.setImage("/images/MainCharacterDown.png");
            repaint();
        }
        else if (collision == true){
            spelerImage = speler.setImage("/images/MainCharacterDown.png");
            repaint();
        }
    }
    
    public void moveCharacterUp(){
        boolean collision = false;
        for(Veld v : maze1Walls){
            int y = v.getY();
            if(y == (spelerY - 35)){
                int x = v.getX();
                if(x == spelerX){
                    collision = true;
                }
            }
        }
        if(collision == false){
            spelerY = spelerY - 35;
            spelerImage = speler.setImage("/images/MainCharacterUp.png");
            repaint();
        }
        else if (collision == true){
            spelerImage = speler.setImage("/images/MainCharacterUp.png");
            repaint();
        }
    }
    
}


