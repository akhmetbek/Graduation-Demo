package model.entity;

import model.State.Rest;
import model.Vector2D;
import model.assesment.AssesmentFactory;
import view.Common;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Speaker extends Entity {

    private BufferedImage image;
    public Speaker(String name, BufferedImage image, Common common, Vector2D position){
        this.image = image;
        this.name  =  name;
        this.common = common;
        state = new Rest();
        this.state.isVisible = false;
        this.position = position;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawImage(image, (int) this.position.x, (int) this.position.y, 40, 55, null);
    }
}
