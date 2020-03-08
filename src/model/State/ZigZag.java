package model.State;

import model.Vector2D;
import model.entity.Entity;
import view.Common;

public class ZigZag extends State {
    private int i = 0;

    public ZigZag(){
        isOver = false;
        isVisible = true;
    }

    @Override
    public void step(Entity e){
        int rn = Common.getInstance().randomInt(5, 10);
        Vector2D dir = new Vector2D(Common.getInstance().randomInt(100, 1100), Common.getInstance().randomInt(100, 500));
        e.position = e.position.plus(dir.minus(e.position).normalize());
        if (i == rn){
            chooseNextState(e);
        }
        i += 1;
    }
}
