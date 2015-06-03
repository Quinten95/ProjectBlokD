/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
/**
 *
 * @author Quinten
 */
public class Doolhof extends JComponent{
    
    Speler speler;
    private Image spelerImage;
    private Image wallImage;    
    private int spelerX;
    private int spelerY;
    private int[][] maze1 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                             {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1},
                             {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                             {1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
                             {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1},
                             {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
                             {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1},
                             {1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                             {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                             {1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                             {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                             {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    
    private Veld[][] bord = new Veld[12][27];
    
    
    public void init(){
        fillBord();
        setNeighbourFields();
        System.out.println(bord[1][0].getRightField().getY());
        createSpeler();
    }
    
    private void fillBord(){
        int x = 1;
        int y = 1;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 27; j++){
                if(maze1[i][j] == 1){
                    bord[i][j] = new Veld(x, y, true);
                }
                else{
                    bord[i][j] = new Veld(x, y, false);
                }
                x = x + 35;
            }
            x = 1;
            y = y + 35;
        }
    }
    
    public void setNeighbourFields(){
        for(int y = 1; y < 11; y++){
            for(int x = 1; x < 26; x++){
                bord[y][x].setDownField(bord[y+1][x]);
                bord[y][x].setUpField(bord[y-1][x]);
                bord[y][x].setLeftField(bord[y][x-1]);
                bord[y][x].setRightField(bord[y][x+1]);           
            }
        }
        for(int y = 0; y < 1; y++){
            for(int x = 1; x < 26; x++){
                bord[y][x].setDownField(bord[y+1][x]);
                bord[y][x].setLeftField(bord[y][x-1]);
                bord[y][x].setRightField(bord[y][x+1]);           
            }
        }
        for(int y = 11; y < 12; y++){
            for(int x = 1; x < 26; x++){
                bord[y][x].setUpField(bord[y-1][x]);
                bord[y][x].setLeftField(bord[y][x-1]);
                bord[y][x].setRightField(bord[y][x+1]);           
            }
        }
        for(int y = 1; y < 11; y++){
            for(int x = 0; x < 1; x++){
                bord[y][x].setDownField(bord[y+1][x]);
                bord[y][x].setUpField(bord[y-1][x]);
                bord[y][x].setRightField(bord[y][x+1]);           
            }
        }
        for(int y = 1; y < 11; y++){
            for(int x = 26; x < 27; x++){
                bord[y][x].setDownField(bord[y+1][x]);
                bord[y][x].setUpField(bord[y-1][x]);
                bord[y][x].setLeftField(bord[y][x-1]);          
            }
        }
    }
    
    private void createSpeler(){
        speler = new Speler();
        spelerImage = speler.setImage("/images/MainCharacterRight.png");
        speler.setMyField(bord[1][1]);
    }
    
    public void paintMaze(){
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        wallImage = this.setWallImage("/images/Wall.jpg");
        for(int y = 0; y < 12; y++){
            for(int x = 0; x < 27; x++){
                if(bord[y][x].getIsWall()){
                    g.drawImage(wallImage, bord[y][x].getX(), bord[y][x].getY(), 35, 35, this);
                }
            }
        }
        
        spelerX = speler.getX();
        spelerY = speler.getY();
        
        g.drawImage(spelerImage, spelerX, spelerY, 30, 30, this);
    } 
       
    public void setImage(String path){
        spelerImage = speler.setImage(path);
    }
    
    public BufferedImage setWallImage(String path){
        BufferedImage image = null;
        try{
            image = ImageIO.read(this.getClass().getResource(path));
        }
        catch(Exception e){
            System.out.println(e);
        }
        return image;
    }
}


