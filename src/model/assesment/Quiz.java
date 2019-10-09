package model.assesment;

import java.awt.*;

public class Quiz extends Assesment {
    public final String name = "Quiz";
    @Override
    public void draw(Graphics2D g2d){
        if(this.state.isVisible) {
            g2d.setColor(Color.BLUE);
            g2d.fillRect((int)position.x, (int)position.y, 20, 20);
            g2d.setColor(Color.BLACK);
            g2d.drawString("" + points, (int) Math.round(position.x), (int) Math.round(position.y));
        }
    }

    @Override
    public void step(){

    }
}
