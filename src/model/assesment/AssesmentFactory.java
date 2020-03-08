package model.assesment;

import model.Vector2D;
import view.Common;

public abstract class AssesmentFactory {
    Common common;
    HomeworkFactory homeworkFactory;
    LabFactory labFactory;
    QuizFactory quizFactory;

    public AssesmentFactory(){
        common = Common.getInstance();
    }

    public abstract Assesment createAssesment(Vector2D position);
}
