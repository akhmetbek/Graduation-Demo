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


        common.students.add(new Student("Kassym Akhmetbek"));
        common.students.add(new Student("Yernur Bayakhmetov"));
        common.students.add(new Student("Alena Sorokina"));
        common.students.add(new Student("Diana Shakenova"));
        common.students.add(new Student("Akylbek Stybaldy"));
        common.students.add(new Student("Adil Bulatov"));

        try {
            common.academicians.add(new Academician("Selim Temizer", ImageIO.read(new File("src/SelimTemizer.gif"))));
            common.academicians.add(new Academician("Hand De Nivelle", ImageIO.read(new File("src/HansDeNivelle.gif"))));
            common.academicians.add(new Academician("Shigeo Katsu", ImageIO.read(new File("src/ShigeoKatsu.gif"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
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


            display.repaint();

            finished = common.students.stream().allMatch(s -> s.finished);

            if(finished){
                display.repaint();
                break;
            }
            common.stepAllEntities();

            i++;

            try {
                Thread.sleep(1);
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
