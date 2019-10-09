package model.entity;

import model.State.Rest;
import model.State.State;
import model.Vector2D;
import model.assesment.Assesment;
import model.assesment.AssesmentFactory;
import view.Common;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Academician extends Entity {
    private AssesmentFactory assesmentFactory;
    private BufferedImage image;

    public Academician(String name, BufferedImage image, Common common){
        this.image = image;
        this.name  =  name;
        this.common = common;
        assesmentFactory = new AssesmentFactory(common);
        state = new Rest();
        this.state.isVisible = true;
        position = new Vector2D(common.randomInt(20, 1180), common.randomInt(20, 580));
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
        Vector2D pos = new Vector2D(common.randomInt(-50, 50), common.randomInt(-50, 50));
        Assesment assesment = assesmentFactory.createAssesment(position.plus(pos));

        return assesment;
    }
}
