package model.assesment;

import model.Vector2D;
import view.Common;

public class AssesmentFactory {
    Common common = null;
    HomeworkFactory homeworkFactory;
    LabFactory labFactory;
    QuizFactory quizFactory;

    public AssesmentFactory(Common common){
        this.common = common;
        homeworkFactory = new HomeworkFactory(common);
        labFactory = new LabFactory(common);
        quizFactory = new QuizFactory(common);
    }

    public AssesmentFactory(){

    }

    public Assesment createAssesment(Vector2D position){
        int r = common.randomInt(1, 3);
        if(r == 1){
            return homeworkFactory.createAssesment(position);
        }else if(r == 2){
            return labFactory.createAssesment(position);
        }else
            return quizFactory.createAssesment(position);
    }
}
