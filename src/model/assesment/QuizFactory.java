package model.assesment;

import model.State.State;
import model.Vector2D;
import view.Common;

public class QuizFactory extends AssesmentFactory{
    private Common common;
    public QuizFactory(){
        common = Common.getInstance();
    }

    @Override
    public Assesment createAssesment(Vector2D position){
        Assesment quiz = new Quiz();
        quiz.state = new State();
        quiz.position = position;
        quiz.points = common.randomInt(3, 5);
        return quiz;
    }
}
