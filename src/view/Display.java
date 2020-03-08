package view;

import model.Vector2D;
import model.entity.Student;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;


public class Display extends JPanel {
    public Common common = Common.getInstance();
    public BufferedImage image;
    public Display(){
        super();
        try {
            image = ImageIO.read(new File("src/NUMap-Faded.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 600);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(image, 0, 0, 1200, 600, null);
        common.drawAllEntities(graphics2D);
    }

}
