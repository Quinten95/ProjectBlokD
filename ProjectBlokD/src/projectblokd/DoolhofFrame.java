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
    Muur muur = new Muur();
    
    
    
    public DoolhofFrame(){
        initComponents();
    }
    class ClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            muur.paintWalls();
        }
    }
    public void initComponents(){
        btn = new JButton("Restart");
        muur.setPreferredSize(new Dimension(950, 500));
        muur.paintWalls();
        panel.add(muur);
        ActionListener listener = new ClickListener();
        btn.addActionListener(listener);
        
        panel.add(btn);
        
        add(panel);
    }
    
}
