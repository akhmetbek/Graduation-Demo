package model.State;

import model.Vector2D;
import model.entity.Entity;

public class ZigZag extends State {
    private int i = 0;

    public ZigZag(){
        isOver = false;
        isVisible = true;
    }

    @Override
    public void step(Entity e){
        int rn = e.common.randomInt(5, 10);
        Vector2D dir = new Vector2D(e.common.randomInt(100, 1100), e.common.randomInt(100, 500));
        e.position = e.position.plus(dir.minus(e.position).normalize());
        if (i == rn){
            chooseNextState(e);
        }
        i += 1;
    }
}
