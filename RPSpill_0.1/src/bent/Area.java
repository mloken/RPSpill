package bent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Area extends Actor {

    public Area(int x, int y) {
        super(x, y);

//        URL loc = this.getClass().getResource("area.png");
//        ImageIcon iia = new ImageIcon(loc);
//        Image image = iia.getImage();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("area.png"));
        } 
        catch (IOException e) {
        }
//        this.setImage(img);
    }
}
