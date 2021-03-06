/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Quinten
 */
public class Doolhof extends JComponent {
    
    private Speler speler;
    private Image spelerImage;
    
    private Cheater cheater1;
    private Cheater cheater2;
    private Cheater cheater3;
    private Image cheater1Image;
    private Image cheater2Image;
    private Image cheater3Image;
    
    private Image wallImage;
    
    private int level = 1;
    
    private Vriend vriend;
    private Image vriendImage;
    
    private Bazooka bazooka1;
    private Bazooka bazooka2;
    private Image bazooka1Image;
    private Image bazooka2Image;
    
    private Helper helper;
    private Image helperImage;
    private Stack<Veld> kortstePad = new Stack<>();
    private int startCounter;
    
    private int[][] levelOne = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
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
    
    private int[][] levelTwo = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1},
                                {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1},
                                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1},
                                {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                                {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                                {1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
                                {1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    
    private int[][] levelThree = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                  {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                                  {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                                  {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                                  {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                                  {1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                                  {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                                  {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                                  {1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                                  {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                                  {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    
    private Veld[][] bord = new Veld[12][27];

    public void init() {
        fillBord();
        setNeighbourFields();
        createSpeler();
        createVriend();
        createCheaters();
        createBazooka();
        createHelper();
        startCounter = 0;
    }

    private void fillBord() {
        int x = 1;
        int y = 1;

        switch (level) {

            case 1:
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 27; j++) {
                        if (levelOne[i][j] == 1) {
                            bord[i][j] = new Veld(x, y, true);
                            if (i < 1 || i > 10 || j < 1 || j > 25) {
                                bord[i][j].setMuur(false);
                            } else {
                                bord[i][j].setMuur(true);
                            }
                        } else {
                            bord[i][j] = new Veld(x, y, false);
                        }
                        x = x + 35;
                    }
                    x = 1;
                    y = y + 35;
                }
                break;

            case 2:
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 27; j++) {
                        if (levelTwo[i][j] == 1) {
                            bord[i][j] = new Veld(x, y, true);
                            if (i < 1 || i > 10 || j < 1 || j > 25) {
                                bord[i][j].setMuur(false);
                            } else {
                                bord[i][j].setMuur(true);
                            }
                        } else {
                            bord[i][j] = new Veld(x, y, false);
                        }
                        x = x + 35;
                    }
                    x = 1;
                    y = y + 35;
                }
                break;

            case 3:
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 27; j++) {
                        if (levelThree[i][j] == 1) {
                            bord[i][j] = new Veld(x, y, true);
                            if (i < 1 || i > 10 || j < 1 || j > 25) {
                                bord[i][j].setMuur(false);
                            } else {
                                bord[i][j].setMuur(true);
                            }
                        } else {
                            bord[i][j] = new Veld(x, y, false);
                        }
                        x = x + 35;
                    }
                    x = 1;
                    y = y + 35;
                }
                break;

        }

    }

    public void setNeighbourFields() {
        for (int y = 1; y < 11; y++) {
            for (int x = 1; x < 26; x++) {
                bord[y][x].setDownField(bord[y + 1][x]);
                bord[y][x].setUpField(bord[y - 1][x]);
                bord[y][x].setLeftField(bord[y][x - 1]);
                bord[y][x].setRightField(bord[y][x + 1]);
            }
        }
        for (int y = 0; y < 1; y++) {
            for (int x = 1; x < 26; x++) {
                bord[y][x].setDownField(bord[y + 1][x]);
                bord[y][x].setLeftField(bord[y][x - 1]);
                bord[y][x].setRightField(bord[y][x + 1]);
            }
        }
        for (int y = 11; y < 12; y++) {
            for (int x = 1; x < 26; x++) {
                bord[y][x].setUpField(bord[y - 1][x]);
                bord[y][x].setLeftField(bord[y][x - 1]);
                bord[y][x].setRightField(bord[y][x + 1]);
            }
        }
        for (int y = 1; y < 11; y++) {
            for (int x = 0; x < 1; x++) {
                bord[y][x].setDownField(bord[y + 1][x]);
                bord[y][x].setUpField(bord[y - 1][x]);
                bord[y][x].setRightField(bord[y][x + 1]);
            }
        }
        for (int y = 1; y < 11; y++) {
            for (int x = 26; x < 27; x++) {
                bord[y][x].setDownField(bord[y + 1][x]);
                bord[y][x].setUpField(bord[y - 1][x]);
                bord[y][x].setLeftField(bord[y][x - 1]);
            }
        }
    }

    private void createSpeler() {
        speler = new Speler();
        switch (level) {
            case 1:
                spelerImage = speler.setImage("/images/MainCharacterRight.png");
                speler.setMyField(bord[1][1]);
                break;

            case 2:
                spelerImage = speler.setImage("/images/MainCharacterUp.png");
                speler.setMyField(bord[10][1]);
                break;
            case 3:
                spelerImage = speler.setImage("/images/MainCharacterRight.png");
                speler.setMyField(bord[6][11]);
        }
    }

    private void createVriend() {
        vriend = new Vriend();
        switch (level) {
            case 1:
                vriendImage = vriend.setImage("/images/FriendDown.png");
                vriend.setMyField(bord[8][25]);
                bord[8][25].setHasFriend(true);
                break;
            case 2:
                vriendImage = vriend.setImage("/images/FriendRight.png");
                vriend.setMyField(bord[8][14]);
                bord[8][25].setHasFriend(false);
                bord[8][14].setHasFriend(true);
                break;
            case 3:
                vriendImage = vriend.setImage("/images/FriendUp.png");
                vriend.setMyField(bord[10][1]);
                bord[8][13].setHasFriend(false);
                bord[10][1].setHasFriend(true);
                break;
        }
    }

    private void createCheaters() {
        cheater1 = new Cheater();
        cheater2 = new Cheater();
        cheater3 = new Cheater();

        cheater1Image = cheater1.setImage("/images/cheater.png");
        cheater2Image = cheater2.setImage("/images/cheater.png");
        cheater3Image = cheater3.setImage("/images/cheater.png");

        switch (level) {
            case 1:
                cheater1.setMyField(bord[6][11]);
                bord[6][11].setItem(cheater1);

                cheater2.setMyField(bord[5][2]);
                bord[5][2].setItem(cheater2);

                cheater3.setMyField(bord[2][21]);
                bord[2][21].setItem(cheater3);
                break;

            case 2:
                cheater1.setMyField(bord[6][15]);
                bord[6][15].setItem(cheater1);

                cheater2.setMyField(bord[5][3]);
                bord[5][3].setItem(cheater2);

                cheater3.setMyField(bord[3][21]);
                bord[3][21].setItem(cheater3);

                break;

            case 3:
                cheater1.setMyField(bord[5][8]);
                bord[5][8].setItem(cheater1);

                cheater2.setMyField(bord[6][1]);
                bord[6][1].setItem(cheater2);

                cheater3.setMyField(bord[2][25]);
                bord[2][25].setItem(cheater3);

                break;
        }
    }
    
    private void createBazooka(){
        bazooka1 = new Bazooka();
        bazooka2 = new Bazooka();
        
        bazooka1Image = bazooka1.setImage("/images/bazooka.png");
        bazooka2Image = bazooka2.setImage("/images/bazooka.png");
        
        switch(level){
            case 1:
                bazooka1.setMyField(bord[10][13]);
                bord[10][13].setItem(bazooka1);
                
                bazooka2.setMyField(bord[1][14]);
                bord[1][14].setItem(bazooka2);
                break;
            case 2:
                bazooka1.setMyField(bord[10][6]);
                bord[10][6].setItem(bazooka1);
                
                bazooka2.setMyField(bord[1][11]);
                bord[1][11].setItem(bazooka2);
                break;
            case 3:
                bazooka1.setMyField(bord[10][3]);
                bord[10][3].setItem(bazooka1);
                
                bazooka2.setMyField(bord[4][25]);
                bord[4][25].setItem(bazooka2);
                break;
        }
    }
    
    private void createHelper(){
        helper = new Helper();
        
        helperImage = helper.setImage("/images/helper.png");
        
        switch(level){
            case 1:
                helper.setMyField(bord[3][4]);
                bord[3][4].setItem(helper);
                break;
            case 2:
                helper.setMyField(bord[3][7]);
                bord[3][7].setItem(helper);
                break;
            case 3:
                helper.setMyField(bord[6][21]);
                bord[6][21].setItem(helper);
                break;
        }
    }
    
    public void fireBazooka(){
        if(speler.getAmmo() > 0){
            Bazooka firedBazooka = new Bazooka();
            firedBazooka.setMyField(speler.getMyField());
            
            firedBazooka.fireBazooka(speler.getLastDirection());
            speler.setAmmo(speler.getAmmo() - 1);
        }
    }

    public void paintMaze() {
        repaint();
    }
    
    public void checkForItems(){
        if (cheater1.getActivated()) {
            cheater1Image = cheater1.setImage("/images/removedItem.png");
        }
        if (cheater2.getActivated()) {
            cheater2Image = cheater2.setImage("/images/removedItem.png");
        }
        if (cheater3.getActivated()) {
            cheater3Image = cheater3.setImage("/images/removedItem.png");
        }
        if(bazooka1.getActivated()){
            bazooka1Image = bazooka1.setImage("/images/removedItem.png");
        }
        if(bazooka2.getActivated()){
            bazooka2Image = bazooka2.setImage("/images/removedItem.png");
        }
        if(helper.getActivated()){
            helperImage = helper.setImage("/images/removedItem.png");
            kortstePad = helper.getKorstePad(speler.getMyField());
            startCounter++;
            if(startCounter > 6){
                kortstePad.clear();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        wallImage = this.setWallImage("/images/wall.png");
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 27; x++) {
                if (bord[y][x].getIsWall()) {
                    g.drawImage(wallImage, bord[y][x].getX(), bord[y][x].getY(), 35, 35, this);
                }
            }
        }
        if(kortstePad.size() > 0){
            for(Veld v : kortstePad){
                g.setColor(Color.GREEN);
                g.fillRect(v.getX(), v.getY(), 30, 30);
            }
        }


        g.drawImage(cheater1Image, cheater1.getMyField().getX(), cheater1.getMyField().getY(), 30, 30, this);
        g.drawImage(cheater2Image, cheater2.getMyField().getX(), cheater2.getMyField().getY(), 30, 30, this);
        g.drawImage(cheater3Image, cheater3.getMyField().getX(), cheater3.getMyField().getY(), 30, 30, this);
        
        g.drawImage(bazooka1Image, bazooka1.getMyField().getX(), bazooka1.getMyField().getY(), 30, 30, this);
        g.drawImage(bazooka2Image, bazooka2.getMyField().getX(), bazooka2.getMyField().getY(), 30, 30, this);
        
        g.drawImage(helperImage, helper.getMyField().getX(), helper.getMyField().getY(), 30, 30, this);
        
        g.drawImage(spelerImage, speler.getMyField().getX(), speler.getMyField().getY(), 30, 30, this);

        g.drawImage(vriendImage, vriend.getMyField().getX(), vriend.getMyField().getY(), 30, 30, this);

    }

    public void moveSpeler(String richting){
        speler.move(richting);
        if (speler.getMyField().getHasFriend()) {
            level++;
            kortstePad.clear();
            init();
        }
        speler.setLastDirection(richting);
    }

    public int getSpelerStappen() {
        return speler.getStappen();
    }

    public int getSpelerAmmo(){
        return speler.getAmmo();
    }
    public void setSpelerImage(String path) {
        spelerImage = speler.setImage(path);
    }
    
    public int getLevel(){
        return level;
    }
    
    public void setLevel(int level){
        this.level = level;
    }
    public BufferedImage setWallImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResource(path));
        } catch (Exception e) {
            System.out.println(e);
        }
        return image;
    }
}
