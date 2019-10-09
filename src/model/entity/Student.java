package model.entity;
import model.State.Closest;
import model.State.Rest;
import model.State.State;
import model.Vector2D;
import model.assesment.Assesment;
import view.Common;

import java.awt.*;

public class Student extends Entity {
    public boolean finished = false;
    public int grade = 0;
    boolean hasTarget = false;
    Vector2D desired = new Vector2D(850, 485);
    public Student(String name, Common common){
        this.common = common;
        this.name  =  name;
        state = new Rest();
        position = new Vector2D(common.randomInt(50, 1190), common.randomInt(50, 580));
    }

    @Override
    public void draw(Graphics2D g2d){
        if(this.state.isVisible){
           g2d.setColor(Color.CYAN);
           g2d.fillOval((int)position.x, (int)position.y, 15, 15);
           g2d.setColor(Color.BLACK);
           g2d.setFont( new Font( "Sans Serif" , Font.BOLD , 14 ) ) ;
           g2d.drawString(name + " " + grade, (int)position.x, (int)position.y);
           g2d.drawOval((int)position.x, (int)position.y, 15, 15);
        }
    }

    public void checkClosest(){
        int minDist = 2000;
        Assesment desiredAssessment = null;

        if(this.common.assessmentNum == 0){
            return ;
        }
        for (Assesment a : this.common.assessments) {
            if (this.position.DistanceTo(a.position) < minDist && a.state.isVisible) {
                desiredAssessment = a;
                minDist = (int)this.position.DistanceTo(a.position);
            }
        }
        if(desiredAssessment == null)
            return ;
        if(this.position.DistanceTo(desiredAssessment.position) < 70){

            this.state = new Closest(desiredAssessment);
            hasTarget = true;
        }
    }

    @Override
    public void step() {
        if (grade < 100){
                if (!hasTarget)
                    this.checkClosest();
            this.state.step(this);
            if (this.state.isOver) {
                if (hasTarget)
                    hasTarget = false;
                State.chooseNextState(this);
            }
        }else if(desired.DistanceTo(position) > 10){
                position = position.plus(desired.minus(position).normalize());
        }else{
            finished = true;
        }
    }
}
