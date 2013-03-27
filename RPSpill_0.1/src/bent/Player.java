package bent;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Player extends Actor {

    public Player(int x, int y) {
        super(x, y);

//        URL loc = this.getClass().getResource("sokoban.png");
//        ImageIcon iia = new ImageIcon(loc);
//        Image image = iia.getImage();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("player.png"));
        } catch (IOException e) {
        }
        this.setImage(img);
    }

    public void move(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
    }
}