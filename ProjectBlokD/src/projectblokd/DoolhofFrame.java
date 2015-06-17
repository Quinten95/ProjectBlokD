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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class DoolhofFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel doolhofPanel;
    private JPanel informationPanel;
    private JPanel buttonPanel;
    private JPanel stappenPanel;
    private JPanel ammoPanel;
    
    private JPanel fillPanel;
    private JPanel fillPanel2;
    private JPanel fillPanel3;
    private JPanel fillPanel4;
    
    private JButton btn;
    Doolhof doolhof = new Doolhof();
    private JLabel aantalStappen;
    private JLabel ammo;
    
    public DoolhofFrame() {
        initComponents();
        setResizable(false);
    }

    class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int confirm = JOptionPane.showConfirmDialog(rootPane, "Wilt u het level herstarten?", "Herstart", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                doolhof.init();
                doolhof.paintMaze();
                doolhof.requestFocusInWindow();
            } else {
                doolhof.requestFocusInWindow();
            }

        }
    }

    class Adapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent evt) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    doolhof.setSpelerImage("/images/MainCharacterDown.png");
                    doolhof.moveSpeler("down");
                    doolhof.checkForItems();
                    lastLevel();
                    doolhof.paintMaze();
                    displayLabels();
                    break;
                case KeyEvent.VK_UP:
                    doolhof.setSpelerImage("/images/MainCharacterUp.png");
                    doolhof.moveSpeler("up");
                    doolhof.checkForItems();
                    lastLevel();
                    doolhof.paintMaze();
                    displayLabels();
                    break;
                case KeyEvent.VK_LEFT:
                    doolhof.setSpelerImage("/images/MainCharacterLeft.png");
                    doolhof.moveSpeler("left");
                    doolhof.checkForItems();
                    lastLevel();
                    doolhof.paintMaze();
                    displayLabels();
                    break;
                case KeyEvent.VK_RIGHT:
                    doolhof.setSpelerImage("/images/MainCharacterRight.png");
                    doolhof.moveSpeler("right");
                    doolhof.checkForItems();
                    lastLevel();
                    doolhof.paintMaze();
                    displayLabels();
                    break;
                case KeyEvent.VK_SPACE:
                    doolhof.fireBazooka();
                    doolhof.paintMaze();
                    displayLabels();
            };
        }
    }

    public void displayLabels() {
        aantalStappen.setText("Stappen: " + doolhof.getSpelerStappen());
        ammo.setText("Ammo: " + doolhof.getSpelerAmmo());
    }
    
    private void lastLevel(){
        if(doolhof.getLevel() == 4){
            int confirm = JOptionPane.showConfirmDialog(rootPane, "U heeft het spel uitgespeeld, wilt u opnieuw beginnen?", "uitgespeeld", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                doolhof.setLevel(1);
                doolhof.init();
                doolhof.requestFocusInWindow();
            }else{
                this.dispose();
            }
        }
    }

    public final void initComponents() {
        doolhof.init();
        doolhof.setPreferredSize(new Dimension(950, 500));
        doolhof.paintMaze();
        doolhof.addKeyListener(new Adapter());
        doolhof.setFocusable(true);
        
        btn = new JButton("Restart");
        ActionListener listener = new ClickListener();
        btn.addActionListener(listener);

        aantalStappen = new JLabel("Stappen: 0");
        ammo = new JLabel("Ammo: 0");
        
        mainPanel = new JPanel(new BorderLayout());
        doolhofPanel = new JPanel();
        informationPanel = new JPanel(new GridLayout(1, 7));
        buttonPanel = new JPanel();
        stappenPanel = new JPanel();
        ammoPanel = new JPanel();
        
        fillPanel = new JPanel();
        fillPanel2 = new JPanel();
        fillPanel3 = new JPanel();
        fillPanel4 = new JPanel();
        
        doolhofPanel.add(doolhof);
        stappenPanel.add(aantalStappen);
        buttonPanel.add(btn);
        ammoPanel.add(ammo);
        
        informationPanel.add(fillPanel);
        informationPanel.add(ammoPanel);
        informationPanel.add(fillPanel2);
        informationPanel.add(buttonPanel);
        informationPanel.add(fillPanel3);
        informationPanel.add(stappenPanel);
        informationPanel.add(fillPanel4);
        
        informationPanel.setPreferredSize(new Dimension(10, 70));
        
        mainPanel.add(doolhofPanel, BorderLayout.CENTER);
        mainPanel.add(informationPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
