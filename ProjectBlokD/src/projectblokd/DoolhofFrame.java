/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Quinten
 */
import javax.swing.*;

public class DoolhofFrame extends JFrame{
    
    private JPanel panel;
    private JButton btn;
    
    public DoolhofFrame(){
        initComponents();
    }
    
    public void initComponents(){
        panel = new JPanel();
        btn = new JButton("Restart");
        panel.add(btn);
        add(panel);
    }
}
