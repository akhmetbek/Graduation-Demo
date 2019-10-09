package model.State;

import model.assesment.Assesment;
import model.entity.Entity;
import model.entity.Student;

public class Closest extends State{

    Assesment a = null;

    public Closest(Assesment a){
        this.a = a;
        this.isOver = false;
        this.isVisible = true;
    }

    public void step(Entity en) {
        Student e = (Student) en;
        if(this.a.state.isVisible){
            e.position = e.position.plus(a.position.minus(e.position).normalize());
            if(e.position.DistanceTo(a.position) <= 10){
                e.grade += a.points;
                a.state.isVisible = false;
                this.isOver = true;
                e.common.assessmentNum--;

            }
        }else {
            this.isOver = true;
        }
    }
}
