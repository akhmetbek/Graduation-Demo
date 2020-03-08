package model.assesment;

import model.State.State;
import model.Vector2D;
import view.Common;

public class HomeworkFactory extends AssesmentFactory{
    private Common common;
    public HomeworkFactory(){
        common = Common.getInstance();
    }

    @Override
    public Assesment createAssesment(Vector2D position){
        Assesment homework = new Homework();
        homework.state = new State();
        homework.position = position;
        homework.points = common.randomInt(1, 3);
        return homework;

    }
}
