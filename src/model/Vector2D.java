package model;

import static java.lang.Math.*;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D v){
        x = v.x;
        y = v.y;
    }

    public double DistanceTo(Vector2D v){
        return Math.sqrt(Math.pow((x - v.x), 2) + Math.pow((y - v.y), 2));
    }

    public Vector2D normalize(){
        double length = Math.sqrt(x*x + y*y);
        if (length == 0){
            return new Vector2D(x, y);
        }
        return new Vector2D(x/length, y/length);
    }

    public Vector2D plus(Vector2D v){
        return new Vector2D(x + v.x, y + v.y);
    }

    public Vector2D minus(Vector2D v){
        return new Vector2D(x - v.x, y - v.y);
    }

}
