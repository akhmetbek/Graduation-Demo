package model.assesment;

import model.State.State;
import model.Vector2D;
import view.Common;

public class QuizFactory extends AssesmentFactory{
    Assesment quiz;

    public QuizFactory(Common common){

        this.common = common;
    }

    @Override
    public Assesment createAssesment(Vector2D position){
        quiz = new Quiz();
        quiz.state = new State();
        quiz.position = position;
        quiz.points = common.randomInt(3, 5);
        return quiz;
    }
}
