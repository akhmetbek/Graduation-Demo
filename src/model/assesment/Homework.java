package model.assesment;

import java.awt.*;

public class Homework extends Assesment {
    public final String name = "Homework";

    public void draw(Graphics2D g2d) {
        if(this.state.isVisible){
            int[] xpts = {(int) Math.round(this.position.x), (int) Math.round(this.position.x - 10), (int) Math.round(this.position.x + 10)};
            int[] ypts = {(int) Math.round(this.position.y + 10), (int) Math.round(this.position.y - 5), (int) Math.round(this.position.y - 5)};
            Polygon polygon = new Polygon(xpts, ypts, 3);
            g2d.setColor(Color.GREEN);
            g2d.fillPolygon(polygon);
            g2d.setColor(Color.BLACK);
            g2d.drawString("" + points, (int) Math.round(position.x), (int) Math.round(position.y));
        }
    }

}
