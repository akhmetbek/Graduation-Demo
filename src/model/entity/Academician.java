package model.entity;

import model.State.Rest;
import model.State.State;
import model.Vector2D;
import model.assesment.*;
import view.Common;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Academician extends Entity {
    private AssesmentFactory[] assesmentFactory;
    private BufferedImage image;
    public Common common;

    public Academician(String name, BufferedImage image){
        this.image = image;
        this.name  =  name;
        common = Common.getInstance();
        state = new Rest();
        this.state.isVisible = true;
        position = new Vector2D(common.randomInt(20, 1180), common.randomInt(20, 580));

        assesmentFactory = new AssesmentFactory[]{new HomeworkFactory(), new QuizFactory(), new LabFactory()};

    }


    @Override
    public void step(){
        int rn = common.randomInt(1, 100);

        if(rn == 1){
            common.assessments.add(createAssesment());
            common.assessmentNum++;
        }
        this.state.step(this);
        if(this.state.isOver){
            State.chooseNextState(this);
        }
    }

    @Override
    public void draw(Graphics2D g2d){
        if (this.state.isVisible) {
            g2d.setColor(Color.BLACK);
            g2d.drawImage(image, (int) this.position.x, (int) this.position.y, 40, 55, null);
        }
    }



    public Assesment createAssesment(){
        int r = common.randomInt(0, 2);
        Vector2D pos = new Vector2D(common.randomInt(-50, 50), common.randomInt(-50, 50));
        return assesmentFactory[r].createAssesment(position.plus(pos));
    }
}
