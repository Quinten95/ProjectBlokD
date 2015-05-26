/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Quinten
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class DoolhofFrame extends JFrame{
    
    private JPanel panel = new JPanel();
    private JButton btn;
    Muur muur = new Muur(true);
    
    
    
    public DoolhofFrame(){
        initComponents();
    }
    
    public void initComponents(){
        btn = new JButton("Restart");
        muur.setPreferredSize(new Dimension(950, 500));
        muur.paintWalls();
        panel.add(muur);
        panel.add(btn);
        
        add(panel);
    }
    
}
