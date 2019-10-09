package model.entity;
import model.State.Rest;
import model.State.State;
import model.Vector2D;
import view.Common;

import java.awt.*;

public abstract class Entity {
    public String name;
    public State state;
    public Common common;
    public Vector2D position;

    public void draw(Graphics2D g2d){

    }
    public void step(){

    }
}
