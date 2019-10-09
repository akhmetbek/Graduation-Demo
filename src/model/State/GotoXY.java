package model.State;

import model.Vector2D;
import model.entity.Entity;

public class GotoXY extends State {
    Vector2D desired;


    public GotoXY(int x, int y){
        desired = new Vector2D(x, y);
        this.isOver = false;
        this.isVisible = true;
    }

    @Override
    public void step(Entity e){
        if(desired.DistanceTo(e.position) < 10){
            this.isOver = true;
        }else {
            e.position = e.position.plus(desired.minus(e.position).normalize());
        }

    }
}
