package model.assesment;

import model.State.State;
import model.Vector2D;
import view.Common;

public class LabFactory extends AssesmentFactory {
    Assesment lab;
    public LabFactory(Common common){
        this.common = common;
    }

    @Override
    public Assesment createAssesment(Vector2D position){
        lab = new Lab();
        lab.position = position;
        lab.state = new State();
        lab.points = common.randomInt(2, 4);
        return lab;
    }
}
