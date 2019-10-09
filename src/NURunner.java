import model.Vector2D;
import model.entity.Academician;
import model.entity.Speaker;
import model.entity.Student;
import view.Common;
import view.Display;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class NURunner {
    public static void main(String[] args) {


        boolean finished = false;
        Display display = new Display();
        Common common = Common.getInstance();

        System.out.println(common.students.toString());

        JFrame window = new JFrame();
        window.setTitle("Graduate Challenge!!!");
        window.setSize(display.getPreferredSize());
        window.setDefaultCloseOperation(3);
        Container cp = window.getContentPane();
        window.add(display);
        window.setResizable(false);
        window.setVisible(true);
        window.pack();
        Graphics2D g2d = (Graphics2D) display.getGraphics();
        int i = 0;
        while(true){

            common.stepAllEntities();
            common.drawAllEntities(g2d);
            if(i == 4){
                display.repaint();
                i = 0;
                finished = common.students.stream().allMatch(s -> s.finished);
            }
            if(finished){
                display.repaint();
                break;
            }

            i++;

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Woops, an error stopping after stepAllentities");
                continue;
            }
        }


        try {
            common.speakers.add(new Speaker("Selim Temizer", ImageIO.read(new File("src/SelimTemizer.gif")), common, new Vector2D(850, 385)));
            common.speakers.add(new Speaker("Hand De Nivelle", ImageIO.read(new File("src/HansDeNivelle.gif")), common, new Vector2D(725, 385)));
            common.speakers.add(new Speaker("Shigeo Katsu", ImageIO.read(new File("src/ShigeoKatsu.gif")), common, new Vector2D(925, 385)));
            common.speakers.add(new Speaker("Kasymzhomart Tokaev", ImageIO.read(new File("src/KassymJomartTokayev.gif")), common, new Vector2D(790, 385)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Speaker s:common.speakers){
            s.draw(g2d);
        }
        for(Student s: common.students){
            s.draw(g2d);
        }
    }
}
