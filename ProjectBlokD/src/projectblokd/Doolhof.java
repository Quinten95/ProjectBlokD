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
    
    Speler speler = new Speler();
    private Image spelerImage;
    private int spelerX;
    private int spelerY;
    private int[][] maze1 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                             {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1},
                             {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                             {1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
                             {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1},
                             {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
                             {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1},
                             {1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                             {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                             {1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                             {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                             {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    
    
    
    
    public void init(){
        spelerImage = speler.setImage("/images/MainCharacterRight.png");
        speler.setY(36);
        speler.setX(36);
    }
    public void paintMaze(){
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        int x = 1;
        int y = 1;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 27; j++){
                if(maze1[i][j] == 1){
                    Veld v = new Veld(x, y, true);
                    v.fillMaze1Fields(v);
                    g.fillRect(x, y, 35, 35);
                }
                else{
                    Veld v = new Veld(x, y, false);
                    v.fillMaze1Fields(v);
                }
                x = x + 35;

            }
            x = 1;
            y = y + 35;
        }
        
        spelerX = speler.getX();
        spelerY = speler.getY();
        
        g.drawImage(spelerImage, spelerX, spelerY, 30, 30, this);
    } 
       
    public void setImage(String path){
        spelerImage = speler.setImage(path);
    }
}


