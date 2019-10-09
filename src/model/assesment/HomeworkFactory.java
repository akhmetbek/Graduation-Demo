package model.assesment;

import model.State.State;
import model.Vector2D;
import view.Common;

public class HomeworkFactory extends AssesmentFactory{
    Assesment homework;
    public HomeworkFactory(Common common){
        this.common = common;
    }
    @Override
    public Assesment createAssesment(Vector2D position){
        homework = new Homework();
        homework.state = new State();
        homework.position = position;
        homework.points = common.randomInt(1, 3);
        return homework;
    }
}
