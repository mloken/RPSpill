package bent;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Wall extends Actor {

    public Wall(int x, int y) {
        super(x, y);

//        URL loc = this.getClass().getResource("wall.png");
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Wall.jpg"));
        } 
        catch (IOException e) {
        	e.printStackTrace();
        }
//        ImageIcon iia = new ImageIcon(loc);
//        image = iia.getImage();
        this.setImage(img);

    }
}