package University;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import course_programme.CourseProgramme;
import module.Module;
import org.joda.time.LocalDate;
import student.Student;

import java.lang.reflect.Array;
import java.util.*;

public class UniversityList {


    public static void main (String args[]) {

        final Student student1 = new Student("Ally Henderson", 21,new Date(15/3/1996));
        final Student student2 = new Student("Jackob Linden", 19,new Date(16/9/1998));
        final Student student3 = new Student("Topher Holder", 23,new Date(23/9/1994));
        final Student student4 = new Student("Ali Hendrix", 20,new Date(1/11/1997));
        final Student student5 = new Student("Mary Burke", 21,new Date(5/3/1996));
        final Student student6 = new Student("Joe Murphy", 20,new Date(17/4/1997));
        final Student student7 = new Student("Enda Mannion", 21,new Date(29/3/1996));
        final Student student8 = new Student("Louise Grady", 21,new Date(6/6/1996));

        ArrayList<Student> mathsStream = new ArrayList<Student>() {{
            add(student1);
            add(student6);
            add(student7);
        }};

        ArrayList<Student> ngtStream = new ArrayList<Student>() {{
            add(student2);
            add(student3);
            add(student4);
            add(student5);
            add(student8);
        }};

        /* students that are in maths stream and ngt stream */
        ArrayList<Student> itStream = new ArrayList<Student>() {{
            add(student1);
            add(student2);
            add(student3);
            add(student4);
            add(student5);
            add(student6);
            add(student7);
            add(student8);
        }};

        final Module CT417 = new Module("Software Engineering III", "CT417", itStream);
        final Module CT413 = new Module("Final Year Project", "CT413", ngtStream);
        final Module CT571 = new Module("Systems Modeling and Simulations", "CT571", mathsStream);

        ArrayList<Module> fourthYearIT = new ArrayList<Module>(){{
            add(CT413);
            add(CT417);
            add(CT571);
        }};

        CourseProgramme NUIG4BCT = new CourseProgramme("Computer Science and Information Technology",fourthYearIT, new LocalDate("2017-09-05"), new LocalDate("2018-05-16"));
        printOutCourseDetails(NUIG4BCT);

    }

    static void printOutCourseDetails(CourseProgramme course){
        System.out.println(course.getCourseName());
        System.out.println("-----------------------");
        ListMultimap<Student, Module> studentModuleMultimap = ArrayListMultimap.create();
        for(Module module: course.getModuleList()){
            for(Student student: module.getStudentList()){
               studentModuleMultimap.put(student,module);
            }
        }

        for (Student student : studentModuleMultimap.keySet()) {
            List<Module> modules = studentModuleMultimap.get(student);
            System.out.println("Student: " + student.getName());
            for(Module mod: modules){
                System.out.println(mod.getModule());
            }

        }

    }
}
