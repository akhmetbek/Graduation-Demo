package view;

import model.Vector2D;
import model.assesment.Assesment;
import model.entity.Academician;
import model.entity.Speaker;
import model.entity.Student;
import model.entity.UniversityMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Common {
    private static Common single_instance   = null;
    public int assessmentNum = 0;
    public int windowHeight;
    public int windowWidth;
    public UniversityMap map;
    public List<Academician> academicians;
    public List<Speaker> speakers;
    public List<Student> students;
    public List<Assesment> assessments;
    public static Random ran;

    private Common(){
        ran = new Random();
        academicians = new LinkedList<Academician>();
        speakers = new LinkedList<Speaker>();
        students = new LinkedList<Student>();
        assessments = new LinkedList<Assesment>();

        windowHeight = 800;
        windowWidth = 1200;
        BufferedImage image = null;

        try {
            academicians.add(new Academician("Selim Temizer", ImageIO.read(new File("src/SelimTemizer.gif")), this));
            academicians.add(new Academician("Hand De Nivelle", ImageIO.read(new File("src/HansDeNivelle.gif")), this));
            academicians.add(new Academician("Shigeo Katsu", ImageIO.read(new File("src/ShigeoKatsu.gif")), this));
        } catch (IOException e) {
            e.printStackTrace();
        }


        students.add(new Student("Kassym Akhmetbek", this));
        students.add(new Student("Yernur Bayakhmetov", this));
        students.add(new Student("Alena Sorokina", this));
        students.add(new Student("Diana Shakenova", this));
        students.add(new Student("Akylbek Stybaldy", this));
        students.add(new Student("Adil Bulatov", this));

    }

    public static Common getInstance(){
        if(single_instance == null){
            single_instance = new Common();
        }

        return single_instance;
    }
    public int randomInt(int from, int to){
        
        int x = ran.nextInt(to - from + 1) + from;
        return  x;
    }

    public void stepAllEntities(){
        if(academicians != null)
            for(Academician a:academicians){
                a.step();
            }
        if(speakers != null)
            for(Speaker a:speakers){
                a.step();
            }
        if(students != null)
            for(Student a:students){
                a.step();
            }
        if(assessments != null)
            for(Assesment a: assessments){
                a.step();
            }
    }

    public void drawAllEntities(Graphics2D g2d){
        for(Academician a:academicians){
            a.draw(g2d);
        }
        for(Speaker a:speakers){
            a.draw(g2d);
        }
        for(Student a:students){
            a.draw(g2d);
        }
        for(Assesment a: assessments){
            a.draw(g2d);
        }
    }


}
