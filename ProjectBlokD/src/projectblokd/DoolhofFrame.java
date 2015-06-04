/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Quinten
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DoolhofFrame extends JFrame{
    
    private JPanel panel = new JPanel();
    private JButton btn;
    Doolhof doolhof = new Doolhof();
    
    public DoolhofFrame(){
        initComponents();
        setResizable(false);
    }
    class ClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            doolhof.init();
            doolhof.paintMaze();
            doolhof.requestFocusInWindow();
            
        }
    }
    
    class Adapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent evt){
            switch (evt.getKeyCode()){
                case KeyEvent.VK_DOWN: doolhof.setSpelerImage("/images/MainCharacterDown.png");
                                       doolhof.moveSpelerDown();
                                       doolhof.paintMaze();
                    break;
                case KeyEvent.VK_UP: doolhof.setSpelerImage("/images/MainCharacterUp.png");
                                     doolhof.moveSpelerUp();
                                     doolhof.paintMaze();
                    break;
                case KeyEvent.VK_LEFT:  
                                       doolhof.setSpelerImage("/images/MainCharacterLeft.png");
                                       doolhof.moveSpelerLeft();
                                       doolhof.paintMaze();
                    break;
                case KeyEvent.VK_RIGHT:                 
                                        doolhof.setSpelerImage("/images/MainCharacterRight.png");
                                        doolhof.moveSpelerRight();
                                        doolhof.paintMaze();
                    break;  
            };
        }
        
    }
    public final void initComponents(){
        btn = new JButton("Restart");
        ActionListener listener = new ClickListener();
        btn.addActionListener(listener);
        
        doolhof.init();
        doolhof.setPreferredSize(new Dimension(950, 500));
        doolhof.paintMaze();
        
        panel.add(doolhof);       
        panel.add(btn);
        doolhof.addKeyListener(new Adapter());
        doolhof.setFocusable(true);
        
        add(panel);
    }
    
}
