/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
/**
 *
 * @author Quinten
 */
public class Doolhof extends JComponent{
    Muur muur = new Muur();
    Speler speler = new Speler();
    
    ArrayList<Veld> maze1Walls = new ArrayList<>();
    
    public void init(){
        muur.fillMaze1();
        maze1Walls = muur.getMaze1();
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
    } 
}


