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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DoolhofFrame extends JFrame{
    
    private JPanel panel = new JPanel();
    private JButton btn;
    Doolhof doolhof = new Doolhof();
    
    
    public DoolhofFrame(){
        initComponents();
    }
    class ClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            doolhof.paintWalls();
        }
    }
    public void initComponents(){
        btn = new JButton("Restart");
        ActionListener listener = new ClickListener();
        btn.addActionListener(listener);
        
        doolhof.init();
        doolhof.setPreferredSize(new Dimension(950, 500));
        doolhof.paintWalls();
        
        panel.add(doolhof);       
        panel.add(btn);
        
        add(panel);
    }
    
}
