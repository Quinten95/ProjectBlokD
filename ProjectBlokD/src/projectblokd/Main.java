/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Quinten
 */
import javax.swing.JFrame;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoolhofFrame frame = new DoolhofFrame();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("MAZE GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
