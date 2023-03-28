package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){

        try{
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_down1"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down2"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/player_down3"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/player_down4"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/player_down5"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/player/player_down6"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left1"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left2"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/player_left3"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/player_left4"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/player_left5"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/player_left6"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right1"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right2"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/player_right3"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/player_right4"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/player_right5"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/player_right6"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up1"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up2"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/player_up3"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/player_up4"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/player_up5"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/player/player_up6"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void  update() {

        if (keyH.upPressed == true ) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }

    }
    public void draw(Graphics2D g2) {

        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
    g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
