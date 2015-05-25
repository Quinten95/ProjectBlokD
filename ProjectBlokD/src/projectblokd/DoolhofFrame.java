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
    private JPanel panel2 = new JPanel();
    private JButton btn;
    private WallComponent walls;
    
    public DoolhofFrame(){
        initComponents();
    }
    
    public void initComponents(){
        panel.setLayout(new GridLayout(10, 20));
        panel2.setLayout(new BorderLayout());
        btn = new JButton("Restart");
        
        walls = new WallComponent();
        walls.setPreferredSize(new Dimension(10, 10));
        walls.showComponent();
        panel.add(walls);
        panel2.add(btn, BorderLayout.NORTH);
        panel2.add(panel, BorderLayout.CENTER);
        add(panel2);
    }
    
}
