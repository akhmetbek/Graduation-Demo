package model.assesment;

import java.awt.*;

public class Lab extends Assesment {
    public final String name = "Lab";


    public void draw(Graphics2D g2d){
        if(this.state.isVisible) {
            g2d.setColor(Color.RED);
            g2d.fillOval((int)position.x, (int)position.y, 20, 20);
            g2d.setColor(Color.BLACK);
            g2d.drawString("" + points, (int) Math.round(position.x), (int) Math.round(position.y));
        }
    }


}
