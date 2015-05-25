/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import javax.swing.JComponent;
import java.awt.Graphics;

public class WallComponent extends JComponent{   
    
    public void showComponent(){
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.fillRect(0, 0, 30, 30);
    }
}
