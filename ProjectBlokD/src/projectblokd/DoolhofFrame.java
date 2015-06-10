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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class DoolhofFrame extends JFrame {

    private JPanel panel = new JPanel();
    private JButton btn;
    Doolhof doolhof = new Doolhof();
    private JLabel aantalStappen;

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
                    doolhof.moveSpelerDown();
                    doolhof.paintMaze();
                    displayStappen();
                    break;
                case KeyEvent.VK_UP:
                    doolhof.setSpelerImage("/images/MainCharacterUp.png");
                    doolhof.moveSpelerUp();
                    doolhof.paintMaze();
                    displayStappen();
                    break;
                case KeyEvent.VK_LEFT:
                    doolhof.setSpelerImage("/images/MainCharacterLeft.png");
                    doolhof.moveSpelerLeft();
                    doolhof.paintMaze();
                    displayStappen();
                    break;
                case KeyEvent.VK_RIGHT:
                    doolhof.setSpelerImage("/images/MainCharacterRight.png");
                    doolhof.moveSpelerRight();
                    doolhof.paintMaze();
                    displayStappen();
                    break;
            };
        }
    }

    public void displayStappen() {
        aantalStappen.setText("Stappen: " + doolhof.getSpelerStappen());
    }

    public final void initComponents() {
        btn = new JButton("Restart");
        ActionListener listener = new ClickListener();
        btn.addActionListener(listener);

        aantalStappen = new JLabel("Stappen: 0");

        doolhof.init();
        doolhof.setPreferredSize(new Dimension(950, 500));
        doolhof.paintMaze();
        doolhof.addKeyListener(new Adapter());
        doolhof.setFocusable(true);

        panel.add(doolhof);
        panel.add(btn);
        panel.add(aantalStappen);

        add(panel);
    }
}
