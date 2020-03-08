package model.State;

import model.entity.Entity;
import view.Common;

public class State {
    public boolean isOver;
    public boolean isVisible;

    public State(){
        isOver = false;
        isVisible = true;
    }

    public static void chooseNextState(Entity e){
        int rn = Common.getInstance().randomInt(1, 3);
        switch (rn){
            case 1:
                int x = Common.getInstance().randomInt(20, 1150);
                int y = Common.getInstance().randomInt(20, 550);
                e.state = new GotoXY(x, y);
                break;
            case 2:
                e.state = new Rest();
                break;
            case 3:
                e.state = new ZigZag();
        }
    }



    public void step(Entity e){
        if(this.isOver){
                chooseNextState(e);
        }
    }
}
