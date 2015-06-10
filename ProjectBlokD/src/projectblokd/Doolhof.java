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
public class Doolhof extends JComponent {

    private Speler speler;
    private Image spelerImage;
    private int cheaterID;
    private Cheater bordCheater1;
    private Cheater bordCheater2;
    private Cheater bordCheater3;
    private Image cheater1Image;
    private Image cheater2Image;
    private Image cheater3Image;
    private Image wallImage;
    private int level = 1;
    private Vriend vriend;
    private Image vriendImage;
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
                            if (i < 1 || i > 11 || j < 1 || j > 26) {
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
                            if (i < 1 || i > 11 || j < 1 || j > 26) {
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
                            if (i < 1 || i > 11 || j < 1 || j > 26) {
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
        bordCheater1 = new Cheater();
        bordCheater2 = new Cheater();
        bordCheater3 = new Cheater();

        cheater1Image = bordCheater1.setImage("/images/cheater.png");
        cheater2Image = bordCheater2.setImage("/images/cheater.png");
        cheater3Image = bordCheater3.setImage("/images/cheater.png");

        switch (level) {
            case 1:
                bordCheater1.setMyField(bord[6][11]);
                bord[6][11].setItem(bordCheater1, 1);

                bordCheater2.setMyField(bord[5][2]);
                bord[5][2].setItem(bordCheater2, 2);

                bordCheater3.setMyField(bord[2][21]);
                bord[2][21].setItem(bordCheater3, 3);
                break;

            case 2:
                bordCheater1.setMyField(bord[6][15]);
                bord[6][15].setItem(bordCheater1, 1);

                bordCheater2.setMyField(bord[5][4]);
                bord[5][4].setItem(bordCheater2, 2);

                bordCheater3.setMyField(bord[3][21]);
                bord[3][21].setItem(bordCheater3, 3);

                break;

            case 3:
                bordCheater1.setMyField(bord[8][11]);
                bord[8][11].setItem(bordCheater1, 1);

                bordCheater2.setMyField(bord[6][1]);
                bord[6][1].setItem(bordCheater2, 2);

                bordCheater3.setMyField(bord[5][17]);
                bord[5][17].setItem(bordCheater3, 3);

                break;

        }
    }

    public void paintMaze() {
        if (cheaterID == 1 && bordCheater1.getActivated() == false) {
            bordCheater1.setActivated();
            cheater1Image = bordCheater1.setImage("/images/removedCheater.png");
        }
        if (cheaterID == 2 && bordCheater2.getActivated() == false) {
            bordCheater2.setActivated();
            cheater2Image = bordCheater2.setImage("/images/removedCheater.png");
        }
        if (cheaterID == 3 && bordCheater3.getActivated() == false) {
            bordCheater3.setActivated();
            cheater3Image = bordCheater3.setImage("/images/removedCheater.png");
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        wallImage = this.setWallImage("/images/Wall.jpg");
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 27; x++) {
                if (bord[y][x].getIsWall()) {
                    g.drawImage(wallImage, bord[y][x].getX(), bord[y][x].getY(), 35, 35, this);
                }
            }
        }


        g.drawImage(cheater1Image, bordCheater1.getX(), bordCheater1.getY(), 30, 30, this);
        g.drawImage(cheater2Image, bordCheater2.getX(), bordCheater2.getY(), 30, 30, this);
        g.drawImage(cheater3Image, bordCheater3.getX(), bordCheater3.getY(), 30, 30, this);

        g.drawImage(spelerImage, speler.getX(), speler.getY(), 30, 30, this);

        g.drawImage(vriendImage, vriend.getX(), vriend.getY(), 30, 30, this);

    }

    public void moveSpelerRight() {
        if (speler.getMyField().getRightField().getIsWall() == false) {
            cheaterID = speler.moveRight();
            speler.setStappen(speler.getStappen() + 1);
        }
        if (speler.getMyField().getHasFriend()) {
            level++;
            init();
        }
    }

    public void moveSpelerLeft() {
        if (speler.getMyField().getLeftField().getIsWall() == false) {
            cheaterID = speler.moveLeft();
            speler.setStappen(speler.getStappen() + 1);
        }
        if (speler.getMyField().getHasFriend()) {
            level++;
            init();
        }
    }

    public void moveSpelerDown() {
        if (speler.getMyField().getDownField().getIsWall() == false) {
            cheaterID = speler.moveDown();
            speler.setStappen(speler.getStappen() + 1);
        }
        if (speler.getMyField().getHasFriend()) {
            level++;
            init();
        }
    }

    public void moveSpelerUp() {
        if (speler.getMyField().getUpField().getIsWall() == false) {
            cheaterID = speler.moveUp();
            speler.setStappen(speler.getStappen() + 1);
        }
        if (speler.getMyField().getHasFriend()) {
            level++;
            init();
        }
    }

    public int getSpelerStappen() {
        return speler.getStappen();
    }

    public void setSpelerImage(String path) {
        spelerImage = speler.setImage(path);
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
